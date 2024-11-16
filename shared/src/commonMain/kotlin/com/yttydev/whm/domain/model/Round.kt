package com.yttydev.whm.domain.model

import kotlin.time.Duration

data class Round(
    val hyperventilationTime: Duration,
    val breathRetentionTime: Duration,
    val deepInhaleAndHoldTime: Duration,
)
