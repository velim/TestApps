package cz.velim.hibernatetest;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cz.velim.hibernatetest.entities.Names;

public class HibernateTest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure() // configures settings
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = null;
		transaction = session.beginTransaction();

		List tests = session.createQuery("from Names").list();
		for (Iterator<Names> iterator = tests.iterator(); iterator.hasNext();) {
			Names tst = (Names) iterator.next();
			System.out.println(tst.getId() + " : " + tst.getName() + "\t: "
					+ tst.getNote());
		}

		transaction.commit();

		System.out.println(args.length);
		if (args.length == 0)
			return;
		// there are some arguments
		System.out.println("add new names");
		Names name = null;

		for (String arg : args) {

			transaction = session.beginTransaction();
			name = new Names();

			name.setName(arg);
			name.setNote(name.getName() + " - note");

			session.save(name);
			transaction.commit();

		}

	}

}
