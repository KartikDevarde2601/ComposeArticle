package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
               ComposeArticle()
            }
                }
            }
        }
    }
@Composable
fun ComposeArticle(){
    ArtistsImage(
        title = stringResource(R.string.jetpack_compose_tutorial),
        titlePara = stringResource(R.string.title_para),
        mainPara = stringResource(R.string.title_main_para)
    )
}

@Composable
fun ArtistsImage (title: String,titlePara: String,mainPara: String){
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null
        )
        Article(title = title, titlePara = titlePara, mainPara = mainPara)
    }
}

@Composable
fun Article (title: String,titlePara: String,mainPara: String,modifier: Modifier=Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        ArticleTitle(title = title)
        ArticleTitlePara(titlePara = titlePara)
        ArticleMainPara(mainPara = mainPara)
    }
}

@Composable
fun ArticleTitle (title:String,modifier: Modifier=Modifier){
    Text(
        text = title,
        fontSize = (24.sp),
        modifier = modifier
            .padding(16.dp)
    )

}

@Composable
fun ArticleTitlePara (titlePara:String,modifier: Modifier=Modifier){
    Text(
        text = titlePara,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp)
    )


}
@Composable
fun ArticleMainPara (mainPara:String,modifier: Modifier=Modifier){
    Text(
        text = mainPara,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArtistsImage(
            title = stringResource(R.string.jetpack_compose_tutorial),
            titlePara = stringResource(R.string.title_para),
            mainPara = stringResource(R.string.title_main_para)
        )
    }
}