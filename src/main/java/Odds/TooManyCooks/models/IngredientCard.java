package Odds.TooManyCooks.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class IngredientCard {
    @EmbeddedId
    private IngredientCardId id;
    @ManyToOne @MapsId("rawIngredientId")
    private RawIngredient rawIngredient;
    @ManyToOne @MapsId("measurementId")
    private Measurement measurement;
}
