package com.example.unitconverter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.times
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.time.times

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun UnitConverter() {
    var inputDropdownMenu by mutableStateOf(false)
    var outputDropdownMenu by mutableStateOf(false)
    var inputUnit by remember { mutableStateOf("Select") }
    var ouputUnit by remember { mutableStateOf("Select") }
    var inputValue by remember { mutableStateOf("") }
    var inputRatio by remember { mutableStateOf(0.0) }
    var outputRatio by remember { mutableStateOf(0.0) }
    var result by remember {
        mutableStateOf(0.0)
    }
    fun calculateRatio(number:Int):Double{
        val number = inputValue.toInt()
        val result = (number * inputRatio)/outputRatio;
        return result

    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Unit Converter", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text(text = "Enter value") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal)
        )
        Row {
            // Input Button
            Button(onClick = { inputDropdownMenu = true }) {
                Row {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(
                    expanded = inputDropdownMenu,
                    onDismissRequest = { inputDropdownMenu = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Milimeter") },
                        onClick = {
                            inputUnit = "Milimeter"
                            inputDropdownMenu = false
                            inputRatio = 0.001
                        })
                    DropdownMenuItem(text = { Text(text = "Centimeter") },
                        onClick = {
                            inputUnit = "Centimeter"
                            inputDropdownMenu = false
                            inputRatio = 0.01
                        })
                    DropdownMenuItem(text = { Text(text = "Meter") },
                        onClick = {
                            inputUnit = "Meter"
                            inputDropdownMenu = false
                            inputRatio = 1.0
                        })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            // Output Button
            Button(onClick = { outputDropdownMenu = true }) {
                Row {
                    Text(text = ouputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(
                    expanded = outputDropdownMenu,
                    onDismissRequest = { outputDropdownMenu = false }) {
                    DropdownMenuItem(text = { Text(text = "Milimeter") }, onClick = {
                        ouputUnit = "Milimeter"
                        outputDropdownMenu = false
                        outputRatio = 0.001
                    })
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = {
                        ouputUnit = "Centimeter"
                        outputDropdownMenu = false
                        outputRatio = 0.01
                    })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                        ouputUnit = "Meter"
                        outputDropdownMenu = false
                        outputRatio = 1.0
                    })

                }
            }
        }
        Button(
            onClick = { result=calculateRatio(inputValue.toInt()) }) {
        Text(text = "DO")
        }

        Text(text = "Result : ${result.toInt()} ", fontSize = 24.sp)

    }


}



@Preview(showSystemUi = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}