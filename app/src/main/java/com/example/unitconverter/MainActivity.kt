package com.example.unitconverter

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme

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
fun UnitConverter(){
    val toast= LocalContext.current
    var dropDownMenu1 by mutableStateOf(false)
    Column (modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Unit Converter", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        OutlinedTextField(modifier = Modifier.padding(16.dp), value = "Text", onValueChange = {})
        Row {
            Button(onClick = { dropDownMenu1 = !dropDownMenu1}) {
               Row {
                   Text(text = "Select")
                   Icon(Icons.Default.ArrowDropDown,contentDescription = null)
               }
                DropdownMenu(expanded = dropDownMenu1, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text ="Centimeter")  },
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text ="Milimeter")  },
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text ="Feet")  },
                        onClick = { /*TODO*/ })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { /*TODO*/ }) {
                Row {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown,contentDescription = null)
                }
            }
        }
        Text(text = "Result :", fontSize = 24.sp)

    }
}

@Preview(showSystemUi = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}