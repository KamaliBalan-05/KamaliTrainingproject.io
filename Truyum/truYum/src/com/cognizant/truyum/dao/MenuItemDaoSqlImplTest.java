package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println(connection);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");

		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name", "Price", "Active", "Date of Launch",
				"Category", "Free Delivery");
		String active;
		String freeDelivery;

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), freeDelivery);
		}
	}

	public static void testGetMenuItemListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println(connection);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");

		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name", "Price", "Active", "Date of Launch",
				"Category", "Free Delivery");
		String active;
		String freeDelivery;

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), freeDelivery);
		}

	}

	public static void testModifyMenuItem() throws NumberFormatException, IOException {
		MenuItem menuItem = new MenuItem(1L, "Pork", 100.00f, true, new DateUtil().convertToDate("12/12/2019"),
				"Dessert", true);

		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();

		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
	}

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItemListAdmin();
	}
}
