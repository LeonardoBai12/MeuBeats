package io.lb.meubeats.headset_feature.domain.use_case

data class HeadsetUseCases(
    val getHeadsetsUseCase: GetHeadsetsUseCase,
    val getHeadsetsFromFirebaseUseCase: GetHeadsetsFromFirebaseUseCase,
    val insertHeadsetToFirebaseUseCase: InsertHeadsetToFirebaseUseCase,
)