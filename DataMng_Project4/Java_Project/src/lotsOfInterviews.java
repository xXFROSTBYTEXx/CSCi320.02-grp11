import com.mongodb.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by bpc2189 on 10/21/16.
 */
public class lotsOfInterviews {
    public static void main(String[] args){

        try{
            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("socialnet");

            System.out.println("Connected to database successfully");

            // recruiter1@email.com has 10 interviews in the month of January in 2014
            for(int i = 1; i < 11; i++) {

                DBCollection collection = db.getCollection("interviews");

                BasicDBObject document = new BasicDBObject();

                document.put("recruiter", "recruiter1@email.com");

                BasicDBObject documentCandidate = new BasicDBObject();
                documentCandidate.put("username", "candidate"+i+"@email.com");
                documentCandidate.put("rescheduled", "false");
                document.put("candidate", documentCandidate);

                BasicDBObject documentParticipant = new BasicDBObject();
                documentParticipant.put("username", "participant"+i+"@email.com");
                documentParticipant.put("replacement", "false");
                document.put("participant", documentParticipant);

                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                document.put("date", format.parse("2014-01-"+i+""));

                BasicDBObject documentCompany = new BasicDBObject();
                documentCompany.put("companyName", "Company"+i+"");
                documentCompany.put("rescheduled", "false");
                document.put("company", documentCompany);

                collection.insert(document);
            }

            // candidate11@email.com has 26 interviews on 2014-01-11
            for(int i = 11; i < 38; i++) {

                DBCollection collection = db.getCollection("interviews");

                BasicDBObject document = new BasicDBObject();

                document.put("recruiter", "recruiter"+i+"@email.com");

                BasicDBObject documentCandidate = new BasicDBObject();
                documentCandidate.put("username", "candidate11@email.com");
                documentCandidate.put("rescheduled", "false");
                document.put("candidate", documentCandidate);

                BasicDBObject documentParticipant = new BasicDBObject();
                documentParticipant.put("username", "participant"+i+"@email.com");
                documentParticipant.put("replacement", "false");
                document.put("participant", documentParticipant);

                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                document.put("date", format.parse("2014-01-11"));

                BasicDBObject documentCompany = new BasicDBObject();
                documentCompany.put("companyName", "Company"+i+"");
                documentCompany.put("rescheduled", "false");
                document.put("company", documentCompany);

                collection.insert(document);
            }

            try {
                // candidate37@email.com needs to update (rescheduled = true)
                DBCollection collection = db.getCollection("interviews");

                BasicDBObject document = new BasicDBObject();

                document.put("recruiter", "recruiter37@email.com");

                BasicDBObject documentCandidate = new BasicDBObject();
                documentCandidate.put("username", "candidate37@email.com");
                documentCandidate.put("rescheduled", "true");
                document.put("candidate", documentCandidate);

                BasicDBObject documentParticipant = new BasicDBObject();
                documentParticipant.put("username", "participant37@email.com");
                documentParticipant.put("replacement", "false");
                document.put("participant", documentParticipant);

                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                document.put("date", format.parse("2014-01-12"));

                BasicDBObject documentCompany = new BasicDBObject();
                documentCompany.put("companyName", "Company37");
                documentCompany.put("rescheduled", "false");
                document.put("company", documentCompany);

                collection.insert(document);
            }
            catch (MongoException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                // participant38@email.com needs to send a replacement (replacement = true)
                DBCollection collection = db.getCollection("interviews");

                BasicDBObject document = new BasicDBObject();

                document.put("recruiter", "recruiter38@email.com");

                BasicDBObject documentCandidate = new BasicDBObject();
                documentCandidate.put("username", "candidate38@email.com");
                documentCandidate.put("rescheduled", "false");
                document.put("candidate", documentCandidate);

                BasicDBObject documentParticipant = new BasicDBObject();
                documentParticipant.put("username", "participant38@email.com");
                documentParticipant.put("replacement", "true");
                document.put("participant", documentParticipant);

                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                document.put("date", format.parse("2014-01-13"));

                BasicDBObject documentCompany = new BasicDBObject();
                documentCompany.put("companyName", "Company38");
                documentCompany.put("rescheduled", "false");
                document.put("company", documentCompany);

                collection.insert(document);

            }
            catch (MongoException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Company39 has 10 rescheduled interviews on 2014-01-14
            // the largest amount of rescheduled interviews of all companies
            for(int i = 39; i < 50; i++) {

                DBCollection collection = db.getCollection("interviews");

                BasicDBObject document = new BasicDBObject();

                document.put("recruiter", "recruiter"+i+"@email.com");

                BasicDBObject documentCandidate = new BasicDBObject();
                documentCandidate.put("username", "candidate"+i+"@email.com");
                documentCandidate.put("rescheduled", "false");
                document.put("candidate", documentCandidate);

                BasicDBObject documentParticipant = new BasicDBObject();
                documentParticipant.put("username", "participant"+i+"@email.com");
                documentParticipant.put("replacement", "false");
                document.put("participant", documentParticipant);

                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                document.put("date", format.parse("2014-01-14"));

                BasicDBObject documentCompany = new BasicDBObject();
                documentCompany.put("companyName", "Company39");
                documentCompany.put("rescheduled", "true");
                document.put("company", documentCompany);

                collection.insert(document);
            }

            for(int i = 50; i < 1000050; i++) {

                DBCollection collection = db.getCollection("interviews");

                BasicDBObject document = new BasicDBObject();

                document.put("recruiter", "recruiter"+i+"@email.com");

                BasicDBObject documentCandidate = new BasicDBObject();
                documentCandidate.put("username", "candidate"+i+"@email.com");
                documentCandidate.put("rescheduled", "false");
                document.put("candidate", documentCandidate);

                BasicDBObject documentParticipant = new BasicDBObject();
                documentParticipant.put("username", "participant"+i+"@email.com");
                documentParticipant.put("replacement", "false");
                document.put("participant", documentParticipant);

                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                document.put("date", format.parse("2014-01-01"));

                BasicDBObject documentCompany = new BasicDBObject();
                documentCompany.put("companyName", "Company"+i+"");
                documentCompany.put("rescheduled", "false");
                document.put("company", documentCompany);

                collection.insert(document);
            }
        }
        catch (MongoException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
