package pl.com.adriandlugosz.RecipeApp.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String description;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "recipe_id",nullable = false)
    private Recipe recipe;
    @OneToOne
    @JoinColumn(name = "unit_of_measure_id",nullable = false)
    private UnitOfMeasure unitOfMeasure;
}
