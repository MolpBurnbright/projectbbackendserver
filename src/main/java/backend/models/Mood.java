package backend.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Mood {

    @Id
    public ObjectId _id;
    public String username;
    public String mood;
    public String datetime;

    public Mood(ObjectId _id, String username, String mood, String datetime) {
        this._id = _id;
        this.username = username;
        this.mood = mood;
        this.datetime = datetime;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id){
        this._id = _id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getMood(){
        return mood;
    }

    public void setMood(String mood){
        this.mood = mood;
    }

    public String getDatetime(){
        return datetime;
    }

    public void setDatetime(String datetime){
        this.datetime = datetime;
    }
}