package io.lb.meubeats.headset_feature.data.data_source

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import io.lb.meubeats.headset_feature.domain.model.Headset

class HeadsetFirebaseDataSource(
    private val database: FirebaseDatabase,
    private val auth: FirebaseAuth,
) {
    fun insertHeadseToFirebase(id: Int, headset: Headset): Task<Void> {
        return database.reference
            .child("headset")
            .child(auth.currentUser!!.uid)
            .child(id.toString())
            .setValue(headset)
    }

    fun logout() {
        auth.signOut()
    }

    fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit): ValueEventListener {
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