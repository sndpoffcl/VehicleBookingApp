package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="VEHICLECATEGORY")
public class VehicleCategory {
    @Id
    int id;
    @Column( nullable = false , unique = true)
    String vehicleCategoryName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleCategory")
    List<VehicleSubCategory> vehicleSubCategoriesList;
}
