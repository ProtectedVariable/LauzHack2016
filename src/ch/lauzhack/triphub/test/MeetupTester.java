package ch.lauzhack.triphub.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ch.lauzhack.triphub.data.SBBParser;
import ch.lauzhack.triphub.engine.Meetup;
import ch.lauzhack.triphub.social.User;
import ch.lauzhack.triphub.trip.Station;
import ch.lauzhack.triphub.trip.Trip;

public class MeetupTester {

	
	public static void main(String[] args) {
		SBBParser issou = new SBBParser();
		Station ge = issou.getStation("Geneva");
		Station zu = issou.getStation("Zurich");
		Station be = issou.getStation("Lausanne");
		Station yv = issou.getStation("Yverdon");
		
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(new SimpleDateFormat("YYYY-MM-dd HH:mm").parse("2016-11-22 17:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User thomas = new User("Thomas", ge, zu, issou.getConnections(ge, zu, c), c);
		User maxime = new User("Maxime", yv, zu, issou.getConnections(yv, zu, c), c);
		User vincent = new User("Vincent", be, zu, issou.getConnections(be, zu, c), c);
		
		/*
		System.out.println(thomas.getPath());
		System.out.println();
		System.out.println(maxime.getPath());
		*/
		
		List<User> users = new ArrayList<>();
		users.add(thomas);
		users.add(maxime);
		users.add(vincent);
		
		Trip t = Meetup.getBestTrip(users);
		for (User user : users) {
			System.out.println(user.getPath());
			System.out.println("-------------------------------");
		}
	}
	
}
