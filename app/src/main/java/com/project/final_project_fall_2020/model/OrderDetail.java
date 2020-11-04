package com.project.final_project_fall_2020.model;

import com.project.final_project_fall_2020.model.IEntity;

import java.io.Serializable;

public class OrderDetail implements IEntity, Serializable {
    private int Id;
    private int productId;
    private int quantity;
    private double totalAmount;

}
