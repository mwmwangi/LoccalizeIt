package com.example.localizeit.business
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun StartingBusinessScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("📘 Starting a Business", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))

        Text("1. Introduction", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Text(
            "Starting a business is both an exciting and challenging journey. " +
                    "It involves identifying a market opportunity, planning carefully, " +
                    "gathering resources, and executing a strategy."
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text("2. Why Start a Business?", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Text("• Freedom & Flexibility: Be your own boss.")
        Text("• Income Potential: No limits on what you can earn.")
        Text("• Solving Problems: Meet local or global needs.")
        Text("• Legacy: Build something meaningful.")
        Spacer(modifier = Modifier.height(12.dp))

        Text("3. Steps to Start a Business", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))

        Text("✅ Step 1: Identify a Business Idea", fontWeight = FontWeight.Bold)
        Text(
            "• Look at local problems and think of solutions.\n" +
                    "• Use your skills, passions, or past work experience.\n" +
                    "• Example: If your community lacks affordable hair salons, that’s a business idea."
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text("✅ Step 2: Conduct Market Research", fontWeight = FontWeight.Bold)
        Text(
            "• Who are your potential customers?\n" +
                    "• What are your competitors doing?\n" +
                    "• What can you do better or differently?"
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text("✅ Step 3: Create a Business Plan", fontWeight = FontWeight.Bold)
        Text(
            "• Outline your goals, costs, pricing, marketing, and operations.\n" +
                    "• Helps you stay focused and attract investors/partners."
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text("✅ Step 4: Register Your Business", fontWeight = FontWeight.Bold)
        Text(
            "• Choose a name and legal structure.\n" +
                    "• Register with the necessary government offices.\n" +
                    "• Obtain any licenses or permits required."
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text("✅ Step 5: Secure Funding", fontWeight = FontWeight.Bold)
        Text(
            "• Use savings, loans, grants, or investors.\n" +
                    "• Know how much money you need to start and sustain operations."
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text("✅ Step 6: Launch and Market Your Business", fontWeight = FontWeight.Bold)
        Text(
            "• Promote through social media, posters, word of mouth, and partnerships.\n" +
                    "• Offer excellent customer service to build trust."
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text("✅ Step 7: Keep Learning and Adapting", fontWeight = FontWeight.Bold)
        Text(
            "• Track your progress, listen to customer feedback, and improve your products or services over time."
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text("🎯 Summary", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Text(
            "Starting a business takes courage, planning, and persistence. " +
                    "With the right mindset and tools, you can turn your idea into a successful enterprise."
        )
    }
}
