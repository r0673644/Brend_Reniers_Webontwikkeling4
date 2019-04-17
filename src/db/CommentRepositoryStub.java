package db;

import domain.Comment;
import domain.Person;
import domain.Role;
import domain.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepositoryStub  implements CommentRepository {
    private Map<String, Topic> topics = new HashMap<String, Topic>();
    public CommentRepositoryStub(){
        Topic music = new Topic("Music","How do you guys like the new Marshmello song?");
        Topic movie = new Topic("Movie","What would you guys rate avengers endgame?");
        Topic sports = new Topic("Sports","Soccer is overrated.");
        Topic games = new Topic("Games","Anybody else realy dislikes fnbr update 8.20?");
        Topic ytttv = new Topic("Youtube and twitch","Dk is the best streamer, change my mind.");

        Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", Role.LID);
        Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", Role.LID);
        Person bartje = new Person("bartje@ucll.be", "t", "Bartje", "Bevers", Role.LID);

        Comment music1 = new Comment(an,"i love it! <3", 10);
        Comment music2 = new Comment(jan, "not realy what i expect from Marshmello.",5);
        Comment music3 = new Comment(bartje,"Marshmello is overrated", 1);

        music.addComment(music1);
        music.addComment(music2);
        music.addComment(music3);

        Comment movie1 = new Comment(bartje,"absolutely amazing",10);
        Comment movie2 = new Comment(jan,"watched it twice already, and cried every minute. A-MA-ZING!!!",10);

        movie.addComment(movie1);
        movie.addComment(movie2);

        Comment sports1 = new Comment(an, "Agreed, the amount of money is just ridiculous!",9);
        Comment sports2 = new Comment(bartje, "are you kidding me? Soccer is the best sports dont @ me!", 1);

        sports.addComment(sports1);
        sports.addComment(sports2);

        Comment games1 = new Comment(jan, "They are killing the game. Revert that shit!", 9);
        Comment games2 = new Comment(bartje, "They are joking aren't they?",8);
        Comment games3 = new Comment(an, "What a joke!",7);
        Comment games4 = new Comment(bartje, "REVERT REVERT REVERT REVERT",8);

        games.addComment(games1);
        games.addComment(games2);
        games.addComment(games3);
        games.addComment(games4);

        Comment yt1 = new Comment(an, "who even is dk?",3);
        Comment yt2 = new Comment(jan, "An, how do you not know Dakotaz? he is really one of the best streamers on twitch!", 9);
        Comment yt3 = new Comment(bartje, "nah i like tfue and ninja way more. they are batter at the game and dk only can snipe.",3);

        ytttv.addComment(yt1);
        ytttv.addComment(yt2);
        ytttv.addComment(yt3);

    }
    @Override
    public void add(Topic topic){
        if(topic == null){
            throw new IllegalArgumentException("No topic given");
        }
        if (topics.containsKey(topic.getDescription())) {
            throw new IllegalArgumentException("This topic already exists.");
        }
        topics.put(topic.getDescription(),topic);
    }

    @Override
    public Topic getTopic(String description) {
        return topics.get(description);
    }

    @Override
    public List<Topic> getAll() {
            return new ArrayList<Topic>(topics.values());
    }
}
