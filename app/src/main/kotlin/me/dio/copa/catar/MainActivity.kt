package me.dio.copa.catar

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.dio.copa.catar.ui.theme.Copa2022Theme
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var click = 0

        setContent {
            Copa2022Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("World")
                }
            }
        }
    }

}

data class Match(
    val name: String,
    val team1: String,
    val team2: String,
    /*val date: Date,
    val stadium: Map<String, String>*/
)

@Composable
fun ListScreen() {
    val matchList = listOf(
        Match("1ª RODADA", "Brasil", "Alemanha"),
        Match("2ª RODADA", "Portugal", "Brasil"),
        Match("3ª RODADA", "Agentina", "Portugal")
    )

    LazyColumn(
        modifier = Modifier.background(Color.White),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 50.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        items(matchList) { item ->
            ItemList(match = item)
        }
    }
}

@Composable
fun ItemList(match: Match) {
    Button(onClick = changeScreen()) {
        Column() {
            Text(text = match.name, modifier = Modifier.background(Color.Black))
            Text(
                text = "${match.team1} vs ${match.team2}",
                modifier = Modifier.background(Color.Magenta)
            )
        }
    }
}

fun changeScreen(): () -> Unit {
    return {
        Log.d("Click", "Clicou para mudar de tela!!")
    }
}

@Composable
fun Greeting(name: String) {
//    Text(text = "Hello $name!")
    ListScreen()
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    Copa2022Theme {
        Greeting("Android")
    }
}
