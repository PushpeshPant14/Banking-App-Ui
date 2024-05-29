package com.example.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.AutoGraph
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.data.Finance
import com.example.bankingappui.ui.theme.BlueStart
import com.example.bankingappui.ui.theme.GreenStart
import com.example.bankingappui.ui.theme.OrangeStart
import com.example.bankingappui.ui.theme.PurpleStart

val FinanceList = listOf(
    Finance(
        icon = Icons.AutoMirrored.Rounded.StarHalf,
        name = "My\nBusiness",
        iconbackground = OrangeStart
    ),Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        iconbackground = BlueStart
    ),Finance(
        icon = Icons.Rounded.AutoGraph,
        name = "Finance\nAnalyse",
        iconbackground = PurpleStart
    ),Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransaction",
        iconbackground = GreenStart
    )
)

@Preview
@Composable
fun FinanceSection(){
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 5.dp, start = 16.dp, bottom = 3.dp)
        )
        LazyRow{
            items(FinanceList.size){
                FinanceItem(it)
            }
        }
    }
}

@Preview
@Composable
fun FinanceItem(
    index:Int
){
    val finance = FinanceList[index]
    var lastpadding = 0.dp
    if(index== FinanceList.size-1) lastpadding=16.dp
    Box(modifier = Modifier.padding(start = 16.dp, end = lastpadding)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { }
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.iconbackground)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }
}