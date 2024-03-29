package org.desktop.demo.containers.details;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.desktop.base.views.components.datatables.AppDataTable;
import org.desktop.demo.containers.details.data.Sportman;
import org.desktop.demo.containers.details.data.SportmanCriteria;
import org.desktop.demo.containers.details.data.SportmanMockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SportmanDataTable extends AppDataTable<Sportman, SportmanCriteria> {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 5190038862045411081L;

	private SportmanMockService service = new SportmanMockService();
	
	@Override
	protected void handlerInitializateGUI() {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected String[] createColumnNames() {
		return new String[]{
				"Id.",
				"First Name",
				"Last Name",
				"Sport",
				"# of Years",
            	"Vegetarian"
			};
	}
	
	@Override
	protected Object handlerGetValueAt(Sportman sportman, int columnIndex) {
		switch (columnIndex) {
		case 0: return sportman.getId();
		case 1: return sportman.getName();
		case 2: return sportman.getSurname();
		case 3: return sportman.getSport();
		case 4: return sportman.getYear();
		case 5: return sportman.getVegetarian();
		default:
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	@Override
	protected JPanel createFilterView() {
		JPanel filterView;
		
		filterView = new JPanel();
		filterView.setLayout(new BorderLayout(5, 5));
		filterView.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
		filterView.add(new JLabel("Filter:"), BorderLayout.WEST);
		filterView.add(new JTextField(), BorderLayout.CENTER);
		filterView.add(new JButton("Search"), BorderLayout.EAST);
		
		// TODO Auto-generated method stub
		return filterView;
	}
	
	@Override
	protected SportmanCriteria buildCriteria(int pageNumber, int pageSize, String sortColumn, String sortOrder) {
		SportmanCriteria criteria;

		criteria = new SportmanCriteria();
		// TODO Auto-generated method stub
		
		criteria.setPageNumber(pageNumber);
		criteria.setPageSize(pageSize);
		criteria.setSortField(sortColumn);
		criteria.setSortOrder(sortOrder);

		return criteria;
	}

	@Override
	protected Integer countByCriteria(SportmanCriteria criteria) {
		return service.countByCriteria(criteria);
	}
	
	@Override
	protected List<Sportman> findByCriteria(SportmanCriteria criteria) {
		return service.findByCriteria(criteria);
	}
	
	public void addRegister(Sportman sportman) {
		log.trace("New Registry: {}", sportman);
		service.save(sportman);
		super.updateView();
	}
	
	@Override
	protected void handlerValueSelected(Sportman valueSelected) {
		log.trace("Selection: value={}", valueSelected);
		
	}
}
