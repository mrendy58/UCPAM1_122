package com.example.p4ucplayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LatihanUCP(
    modifier: Modifier = Modifier
){
    Box(
        modifier = Modifier
            .fillMaxWidth()


    ){
        Column(
            modifier = Modifier.padding(14.dp)
        ){
            Text(text = "Pemesanan")
        }
        var keberangkatan by remember { mutableStateOf("") }
        var kedatangan by remember { mutableStateOf("") }
        var tglkbr by remember { mutableStateOf("") }
        var tglkdt by remember { mutableStateOf("") }

        val dataClass = listOf("Ekonomi", "Bussiness")
        var selectedClass by remember { mutableStateOf(dataClass[0]) }

        var confKeberangkatan by remember { mutableStateOf("") }
        var confKedatangan by remember { mutableStateOf("") }
        var confTglKbr by remember { mutableStateOf("") }
        var confTglKdt by remember { mutableStateOf("") }
        var confClass by remember { mutableStateOf("") }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally


        ){
            HeaderSection()
            TextField(
                value = keberangkatan,
                onValueChange = { keberangkatan = it },
                label = { Text(text = "Keberangkatan") },
                placeholder = { Text(text = "Stasiun Keberangkatan Anda") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            TextField(
                value = kedatangan,
                onValueChange = { kedatangan = it },
                label = { Text(text = "Kedatangan") },
                placeholder = { Text(text = "Stasiun Tujuan Anda") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            TextField(
                value = tglkbr,
                onValueChange = { tglkbr = it },
                label = { Text(text = "Tanggal Keberangkatan") },
                placeholder = { Text(text = "Isi Tanggal Keberangkatan Anda") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            TextField(
                value = tglkdt,
                onValueChange = { tglkdt = it },
                label = { Text(text = "Tanggal Kedtangan") },
                placeholder = { Text(text = "Isi Tanggal Kedatangan Anda") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            // memilih class
            Text(text = "Class:")
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(5.dp)

            ){
                dataClass.forEach { classOption ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        RadioButton(
                            selected = (classOption == selectedClass),
                            onClick = { selectedClass = classOption }
                        )
                        Text(text = classOption, modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }

            Button(
                onClick = {
                    confKeberangkatan = kedatangan
                    confKedatangan = kedatangan
                    confTglKbr = tglkbr
                    confTglKdt = tglkdt
                    confClass = selectedClass
                },
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Simpan")
            }
            // Menampilkan data setelah tombol Simpan ditekan
            DetailData(param = "Keberangkatan", argu = confKeberangkatan)
            DetailData(param = "Kedatangan", argu = confKedatangan)
            DetailData(param = "Tanggal Keberangkatan", argu = confTglKbr)
            DetailData(param = "Tanggal Kedatangan", argu = confTglKdt)
            DetailData(param = "Class", argu = confClass)



        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ){
        Column(
            modifier = Modifier.padding(14.dp)
        ){
            Text(text = "Detail Data")
        }

    }
}

@Composable
fun DetailData(
    param: String,
    argu: String
){
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "$param:",
                modifier = Modifier.weight(1f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(text = "Good Afternoon,")
                Text(text = "Muhamad Rendy Maulana Bakti")
            }
        }
    }
}

