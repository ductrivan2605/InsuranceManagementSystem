module com.insurancemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires spring.beans;
    requires spring.web;
    requires spring.context;
    requires spring.tx;
    requires spring.data.commons;
    requires org.postgresql.jdbc;

    opens com.insurancemanagementsystem.controller to javafx.fxml;
    opens com.insurancemanagementsystem.model to javafx.base;
    exports com.insurancemanagementsystem;
    exports com.insurancemanagementsystem.controller;
}