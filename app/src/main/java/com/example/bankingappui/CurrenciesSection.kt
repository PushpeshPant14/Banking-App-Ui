package com.example.bankingappui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.data.Currency
import com.example.bankingappui.ui.theme.GreenStart


val CurrencyList = listOf(
    Currency(
        name = "USD", buy = 23.25f, sell = 22.23f, icon = Icons.Rounded.AttachMoney
    ),

    Currency(
        name = "EUR", buy = 13.35f, sell = 13.25f, icon = Icons.Rounded.Euro
    ),

    Currency(
        name = "YEN", buy = 26.35f, sell = 26.35f, icon = Icons.Rounded.CurrencyYen
    ),

    Currency(
        name = "USD", buy = 23.35f, sell = 23.25f, icon = Icons.Rounded.AttachMoney
    ),

    Currency(
        name = "EUR", buy = 63.35f, sell = 73.25f, icon = Icons.Rounded.Euro
    ),

    Currency(
        name = "YEN", buy = 16.35f, sell = 16.35f, icon = Icons.Rounded.CurrencyYen
    ),
)


@Preview
@Composable
fun CurrenciesSection(
) {
    var isVisible by remember {
        mutableStateOf(true)
    }
    var iconImage by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        iconImage = if (isVisible) {
                            Icons.Rounded.KeyboardArrowUp
                        } else Icons.Rounded.KeyboardArrowDown
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        imageVector = iconImage,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Text(
                    text = "Currencies",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
            )

            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)

                ) {
                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier.width(width),
                                text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                            Text(
                                modifier = Modifier
                                    .width(width),
                                text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.End
                            )
                            Text(
                                modifier = Modifier.width(width),
                                text = "Sell",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.End
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(CurrencyList.size) { index ->
                                CurrencyItem(index, width)
                            }
                        }

                    }
                }
            }
        }
    }
}


@Composable
fun CurrencyItem(
    index: Int, width: Dp
) {
    val currency = CurrencyList[index]
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .padding(start=10.dp),
                text = currency.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
        }
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${currency.buy}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${currency.sell}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )
    }
}