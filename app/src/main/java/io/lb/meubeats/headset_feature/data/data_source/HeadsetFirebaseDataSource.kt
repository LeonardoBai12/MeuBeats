package io.lb.meubeats.headset_feature.data.data_source

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.model.InvalidHeadsetException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class HeadsetFirebaseDataSource(
    private val database: FirebaseDatabase,
    private val auth: FirebaseAuth,
) {
    fun insertHeadset(id: Int, headset: Headset): Task<Void> {
        return auth.currentUser?.let {
            database.reference
                .child("headset")
                .child(auth.currentUser!!.uid)
                .child(id.toString())
                .setValue(headset)
        } ?: throw InvalidHeadsetException("Houve um erro ao comprar o produto!")
    }

    fun logout() {
        auth.signOut()
    }

    suspend fun getBoughtHeadsetsUseCase() : List<Headset> = suspendCancellableCoroutine {
        database.getReference("headset").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val hashMap = snapshot.getValue<HashMap<String, List<Headset>>>()
                    if (it.isActive) {
                        it.resume(hashMap?.get(auth.uid) ?: listOf())
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }
            }
        )

    }
}