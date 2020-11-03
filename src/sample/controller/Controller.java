package sample.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.ControllerUtil;
import sample.model.ModelTableCourses;
import sample.model.ModelTableLessons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    Connection connection = null;

    public Controller() throws ClassNotFoundException {
        connection = ControllerUtil.connectionDB();
    }


    @FXML
    private TableView<ModelTableCourses> tableCourses;

    @FXML
    private TableColumn<ModelTableCourses, String> tableCoursesID;

    @FXML
    private TableColumn<ModelTableCourses, String> tableCoursesTitle;

    @FXML
    private TableColumn<ModelTableCourses, String> tableCoursesLength;

    @FXML
    private TableColumn<ModelTableCourses, String> tableCoursesDescription;

    @FXML
    public void initialize() {
        //Courses
        ObservableList<ModelTableCourses> listTableCourses = FXCollections.observableArrayList();

        String sqlTableCourses = "SELECT * FROM courses";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlTableCourses);
            ResultSet resultTableCourses = statement.executeQuery();
            while (resultTableCourses.next()) {

                listTableCourses.add(new ModelTableCourses(
                        resultTableCourses.getString(1),
                        resultTableCourses.getString(2),
                        resultTableCourses.getString(3),
                        resultTableCourses.getString(4)));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        tableCoursesID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableCoursesTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableCoursesLength.setCellValueFactory(new PropertyValueFactory<>("length"));
        tableCoursesDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        tableCourses.setItems(listTableCourses);
        //Lessons
        ObservableList<ModelTableLessons> listTableLessons = FXCollections.observableArrayList();

        String sqlTableLessons = "SELECT * FROM lessons";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlTableLessons);
            ResultSet resultTableLessons = statement.executeQuery();
            while (resultTableLessons.next()) {

                listTableLessons.add(new ModelTableLessons(
                        resultTableLessons.getString(1),
                        resultTableLessons.getString(2),
                        resultTableLessons.getString(3),
                        resultTableLessons.getString(4),
                        resultTableLessons.getString(5)));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}