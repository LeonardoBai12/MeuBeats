package io.lb.meubeats.headset_feature.domain.use_case

data class HeadsetUseCases(
    val getHeadsetsUseCase: GetHeadsetsUseCase,
    val getBoughtHeadsetsUseCase: GetBoughtHeadsetsUseCase,
    val insertHeadsetToFirebaseUseCase: InsertHeadsetToFirebaseUseCase,
    val logoutUseCase: LogoutUseCase,
)