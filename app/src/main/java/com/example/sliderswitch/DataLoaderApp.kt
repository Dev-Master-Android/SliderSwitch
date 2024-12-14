package com.example.sliderswitch

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun DataLoaderApp() {
    var isSwitchOn by remember { mutableStateOf(false) }
    var data by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Переключатель для загрузки данных")
        Spacer(modifier = Modifier.height(8.dp))
        Switch(
            checked = isSwitchOn,
            onCheckedChange = { isSwitchOn = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (isSwitchOn) {
                    data = """
                        Список пользователей:
                        1. Иван Иванов
                           Email: ivanov@example.com
                           Телефон: +7 123 456 7890
                        2. Мария Смирнова
                           Email: smirnova@example.com
                           Телефон: +7 987 654 3210
                        3. Алексей Петров
                           Email: petrov@example.com
                           Телефон: +7 555 123 4567
                        4. Анна Кузнецова
                           Email: kuznetsova@example.com
                           Телефон: +7 777 890 1234
                        """.trimIndent()
                    Toast.makeText(context, "Загрузка данных...", Toast.LENGTH_SHORT).show()
                } else {
                    data = ""
                    Toast.makeText(context, "Нет доступа", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSwitchOn) Color.Blue else Color.Gray,
                contentColor = if (isSwitchOn) Color.White else Color.Black
            ),
            enabled = true,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Загрузить данные")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(data)
    }
}
