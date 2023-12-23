package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
private fun ArtSpaceContent(drawableResourceId:Int,
                            contentDescriptionResourceId : Int,
                            txtId : Int,
                            onPreviousButtonClick:()->Unit,
                            onNextButtonClick:()->Unit) {
    Column(modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = drawableResourceId),
            contentDescription = stringResource(id = contentDescriptionResourceId),
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_vertical)))

        Text(text = stringResource(id = txtId), modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(10.dp),
            fontSize = 10.sp,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Start)

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_vertical)))

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = onPreviousButtonClick,
                modifier = Modifier
                    .padding(15.dp)
                    .size(height = 50.dp, width = 120.dp),
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)) {
                Text(text = stringResource(id = R.string.previous_button), fontSize = 12.sp)
            }
            
            Button(onClick = onNextButtonClick,
                modifier = Modifier
                    .padding(15.dp)
                    .size(height = 50.dp, width = 120.dp),
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)) {
                Text(text = stringResource(id = R.string.next_button), fontSize = 12.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ArtSpaceLayout() {
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Art Space",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.tata_safari,
                        contentDescriptionResourceId = R.string.image_one_discription,
                        txtId = R.string.content_discription_one,
                        onPreviousButtonClick = {

                        },
                        onNextButtonClick = {
                            currentStep = 2
                        }
                    )
                }

                2 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.audi_r8,
                        contentDescriptionResourceId = R.string.image_two_discription,
                        txtId = R.string.content_discription_two,
                        onPreviousButtonClick = {
                            currentStep = 1
                        },
                        onNextButtonClick = {
                            currentStep = 3
                        }
                    )
                }

                3 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.range_rover,
                        contentDescriptionResourceId = R.string.image_three_discription,
                        txtId = R.string.content_discription_three,
                        onPreviousButtonClick = {
                            currentStep = 2
                        },
                        onNextButtonClick = {
                            currentStep = 4
                        }
                    )
                }

                4 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.buggati_chiron,
                        contentDescriptionResourceId = R.string.image_four_discription,
                        txtId = R.string.content_discription_four,
                        onPreviousButtonClick = {
                            currentStep = 3
                        },
                        onNextButtonClick = {
                            currentStep = 5
                        }
                    )
                }

                5 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.bmw,
                        contentDescriptionResourceId = R.string.image_five_discription,
                        txtId = R.string.content_discription_five,
                        onPreviousButtonClick = {
                            currentStep = 4
                        },
                        onNextButtonClick = {
                            currentStep = 6
                        }
                    )
                }

                6 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.fortuner,
                        contentDescriptionResourceId = R.string.image_six_discription,
                        txtId = R.string.content_discription_six,
                        onPreviousButtonClick = {
                            currentStep = 5
                        },
                        onNextButtonClick = {
                            currentStep = 7
                        }
                    )
                }

                7 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.tesla,
                        contentDescriptionResourceId = R.string.image_seven_discription,
                        txtId = R.string.content_discription_seven,
                        onPreviousButtonClick = {
                            currentStep = 6
                        },
                        onNextButtonClick = {
                            currentStep = 8
                        }
                    )
                }

                8 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.jaguar,
                        contentDescriptionResourceId = R.string.image_eight_discription,
                        txtId = R.string.content_discription_eight,
                        onPreviousButtonClick = {
                            currentStep = 7
                        },
                        onNextButtonClick = {
                            currentStep = 9
                        }
                    )
                }

                9 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.hyundai,
                        contentDescriptionResourceId = R.string.image_nine_discription,
                        txtId = R.string.content_discription_nine,
                        onPreviousButtonClick = {
                            currentStep = 8
                        },
                        onNextButtonClick = {

                        }
                    )
                }

                10 -> {
                    ArtSpaceContent(
                        drawableResourceId = R.drawable.honda_city,
                        contentDescriptionResourceId = R.string.image_ten_discription,
                        txtId = R.string.content_discription_ten,
                        onPreviousButtonClick = {
                            currentStep = 1
                        },
                        onNextButtonClick = {
                            currentStep = 2
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ArtSpaceLayoutPreview() {
    ArtSpaceAppTheme {
        ArtSpaceLayout()
    }
}