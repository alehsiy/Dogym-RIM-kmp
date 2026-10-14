package com.example.mykekapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private data class Character(
    val name: String,
    val species: String,
    val status: String
)

private val characters = listOf(
    Character("Rick Sanchez", "Human", "Alive"),
    Character("Morty Smith", "Human", "Alive"),
    Character("Summer Smith", "Human", "Alive"),
    Character("Beth Smith", "Human", "Alive"),
    Character("Jerry Smith", "Human", "Alive"),
    Character("Birdperson", "Birdperson", "Alive"),
    Character("Mr. Meeseeks", "Meeseeks", "Unknown"),
    Character("Squanchy", "Cat-like creature", "Alive"),
    Character("Evil Morty", "Human", "Alive"),
    Character("Unity", "Hive mind", "Dead"),
    Character("Abradolf Lincler", "Human", "Unknown"),
    Character("Mr. Poopybutthole", "Poopybutthole", "Alive")
)

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize() // Занимаем весь экран.
                .background(Color(0xFFF5F5F5)) // Рисуем фон безопасной области.
                .safeDrawingPadding() // Учитываем статус-бар, вырез, Dynamic Island и нижнюю системную область.
                .padding(horizontal = 16.dp) // Добавляем отступы слева и справа от контента.
        ) {
            Text(
                text = "Rick and Morty characters",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f) // Занимаем оставшееся место после заголовка.
                    .fillMaxWidth(), // Растягиваем список на всю ширину Column.
                contentPadding = PaddingValues(bottom = 16.dp), // Оставляем место после последнего элемента.
                verticalArrangement = Arrangement.spacedBy(10.dp) // Расстояние между элементами списка.

            ) {
                items(characters) { character ->
                    CharacterRow(character)
                }
            }
        }
    }
}

@Composable
private fun CharacterRow(character: Character) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color(0xFF8BC34A))
        )

        Spacer(
            modifier = Modifier.width(12.dp)
        )


        Column {
            Text(
                text = character.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "${character.status} · ${character.species}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}
