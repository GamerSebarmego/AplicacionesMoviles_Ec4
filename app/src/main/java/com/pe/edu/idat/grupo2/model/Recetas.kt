package com.pe.edu.idat.grupo2.model
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "receta")//se crea como tabla
@Parcelize
data class Recetas(
    @PrimaryKey(autoGenerate = true)
    //@SerializedName("idMeal")
    val idMeal: Int,
    @SerializedName("strMeal")
    val strMeal: String,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strArea")
    val strArea: String,
    @SerializedName("strInstructions")
    val strInstructions: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String,
    var isFavorite:Boolean = false
) :Parcelable {

}
//fun getData():List<Recetas> = listOf()