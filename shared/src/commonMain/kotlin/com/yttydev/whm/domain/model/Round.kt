package com.yttydev.whm.domain.model

import kotlin.time.Duration

data class RoundDto(
    val hyperventilationTime: Duration,
    val breathRetentionTime: Duration,
    val deepInhaleAndHoldTime: Duration,
)
