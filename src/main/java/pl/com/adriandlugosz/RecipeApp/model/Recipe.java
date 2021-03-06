package pl.com.adriandlugosz.RecipeApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String description;
    private int prepTime;
    private int cookTime;
    private int servings;
    private String source;
    private String url;
    private String directions;
    @OneToOne(mappedBy = "recipe")
    private Note note;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    @Lob
    private Byte[] image;
    @OneToMany(mappedBy = "recipe")
    private Set<Ingredient> ingredients;
    @ManyToMany
    @JoinTable(name = "recipe_category",joinColumns = @JoinColumn(name = "recipe_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;


}
