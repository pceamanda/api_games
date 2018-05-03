package com.fiap.amanda.gamesapi.service

import com.fiap.amanda.gamesapi.entity.CustomSequences
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndModifyOptions.options
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.stereotype.Service


@Service
class NextSequenceService {

    @Autowired
    private val mongo: MongoOperations? = null

    fun getNextSequence(seqName: String): Long {
        val counter = mongo!!.findAndModify(
                query(where("_id").`is`(seqName)),
                Update().inc("seq", 1),
                options().returnNew(true).upsert(true),
                CustomSequences::class.java)
        return counter!!.seq
    }
}
