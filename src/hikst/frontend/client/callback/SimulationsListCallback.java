package hikst.frontend.client.callback;

import java.util.ArrayList;

import hikst.frontend.client.DatabaseService;
import hikst.frontend.client.DatabaseServiceAsync;
import hikst.frontend.shared.ImpactType;
import hikst.frontend.shared.ViewSimulationObject;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class SimulationsListCallback implements AsyncCallback<ArrayList<ViewSimulationObject>> {

	private FlexTable SimulationsTable;

	private DatabaseServiceAsync databaseService = GWT
			.create(DatabaseService.class);

	public SimulationsListCallback(FlexTable table) {
		SimulationsTable = table;
	}

	@Override
	public void onFailure(Throwable caught) {

		Window.alert("Server failure : " + caught.getMessage());

	}

	@Override
	public void onSuccess(ArrayList<ViewSimulationObject> result) {
		// TODO Auto-generated method stub
		
		 updateTable(result);
	}
	
	private void updateTable(ArrayList<ViewSimulationObject> simulations) {
		SimulationsTable.clear();
		SimulationsTable.setWidget(0, 0, new Label(""));
		
		SimulationsTable.setWidget(0, 1, new Label("Objektnavn"));
		SimulationsTable.setWidget(0, 2, new Label("Status"));
		
		for (int i = 0; i < simulations.size(); i++)  {
			ViewSimulationObject v = simulations.get(i);
			SimulationsTable.setWidget(i+1, 0, new Button("Velg simulering", new ClickHandler() 
			{
				@Override
				public void onClick(ClickEvent event) {
					

				}

			}));
			SimulationsTable.setWidget(i+1, 1, new Label(v.Object_Name));
			SimulationsTable.setWidget(i+1, 2, new Label(v.Status_Name));
		
		}
	}
}
