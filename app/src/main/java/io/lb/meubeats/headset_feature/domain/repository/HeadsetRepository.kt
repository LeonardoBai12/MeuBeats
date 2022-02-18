package io.lb.meubeats.headset_feature.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import io.lb.meubeats.headset_feature.domain.model.Headset

class HeadsetRepository(
    private val database: FirebaseDatabase,
    private val auth: FirebaseAuth,
) {
    fun insertHeadset(
        id: Int,
        headset: Headset,
        onCompleted: (Boolean, Exception?) -> Unit
    ): Task<Void> {
        return database.reference
            .child("headset")
            .child(auth.currentUser!!.uid)
            .child(id.toString())
            .setValue(headset).addOnCompleteListener {
                onCompleted(it.isSuccessful, it.exception)
            }
    }

    fun loadHeadsets(): Task<DataSnapshot> {
        return database.getReference("headset").get()
    }

    fun loadHeadsetsListener(onDataChanged: (ArrayList<Headset>) -> Unit): ValueEventListener {
        return database.getReference("headset").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val hashMap = snapshot.getValue<HashMap<String, ArrayList<Headset>>>()
                    val headsets = hashMap?.get(auth.uid)
                    onDataChanged(headsets ?: arrayListOf())
                }

                override fun onCancelled(error: DatabaseError) {
                }
            }
        )
    }
}