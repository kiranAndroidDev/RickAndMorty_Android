package com.example.rickandmorty_android.character.v1.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmorty_android.data.CharacterModel

const val STATUS = "STATUS :"

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CharacterItem(item: CharacterModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 6.dp,
        border = BorderStroke(0.dp, Color.Gray),
        shape = RoundedCornerShape(4.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp, 8.dp)
                .fillMaxWidth(),
        ) {
            drawProfileImage(url = item.image)
            Spacer(Modifier.padding(8.dp, 0.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(4.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = item.name,
                    color = Color.Black,
                    fontSize = TextUnit(18f, TextUnitType.Sp))
                Text(text = "${item.species} , ${item.gender}",
                    color = Color.Black,
                    fontSize = TextUnit(14f, TextUnitType.Sp))
                Text(text = item.origin.name, color = Color.Black,
                    fontSize = TextUnit(14f, TextUnitType.Sp))
                drawStatusChip(status = item.status)
            }
        }
    }
}

@Composable
fun drawProfileImage(url: String) {
    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier.clip(CircleShape)
    )
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun drawStatusChip(status: String) {
    Row() {
        Text(
            text = STATUS,
            fontSize = TextUnit(14f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.padding(4.dp))
        Text(
            text = status.toUpperCase(),
            fontWeight = FontWeight.ExtraBold,
            fontSize = TextUnit(14f, TextUnitType.Sp),
            color = when (status) {
                "Alive" -> Color.Green
                "Dead" -> Color.Red
                else -> Color.Gray
            }
        )
    }
}
