package com.xzit.rxjava;



import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.Subscriber;

	

public class TestRxjava {
	public static void main(String[] args) {
		//1.
//		Observable<String> myObservable = Observable.create(new OnSubscribe<String>() {
//
//			public void call(Subscriber<? super String> sub) {
//				sub.onNext("Hello World");
//				sub.onCompleted();
//			}
//			
//		});
//		Subscriber<String> mySubscriber = new Subscriber<String>() {
//
//			public void onCompleted() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void onError(Throwable arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void onNext(String s) {
//				
//				System.out.println(s);
//			}
//		};
//		myObservable.subscribe(mySubscriber);
//		2.
//		Observable<String> myObservable = Observable.just("Hello World");
//		Action1<String> onNextAction1 = new Action1<String>() {
//
//			public void call(String s) {
//				System.out.println(s);
//			}
//		};
//		myObservable.subscribe(onNextAction1);
		//3.
//		Observable.just("hello World").subscribe(new Action1<String>() {
//
//			public void call(String s) {
//				System.out.println(s);
//			}
//		});s
		//4.
//		Observable.just("Hello World").subscribe(s->System.out.println(s));
		Observable a = Observable.just("Hello World");
//		List<String> list = initData();
//		
//		Observable.from(list).subscribe(new Action1<String>() {
//
//			public void call(String s) {
//				System.out.println(s);
//			}
//		});
		
		Observable.from(getTeachers())
			.flatMap(new Func1<Teacher, Observable<Student>>() {

				public Observable<Student> call(Teacher teacher) {
					
					return Observable.from(teacher.getStudents());
				}
			}).filter(new Func1<Student, Boolean>() {

				public Boolean call(Student student) {
					// TODO Auto-generated method stub
					return Integer.parseInt(student.getSid())>1;
				}
			})
			.subscribe(new Subscriber<Student>() {

				public void onCompleted() {
					
				}

				public void onError(Throwable e) {
					System.out.println(e.getMessage());
				}

				public void onNext(Student student) {
					System.out.println(student.getName());
				}

				
			});
		
		
		
	}
	public static List<Teacher> getTeachers(){
		Teacher teacher = new Teacher();
		teacher.setId("001");
		teacher.setName("zyh");
		teacher.setStudents(getStudent1s());
		
		Teacher teacher1 = new Teacher();
		teacher1.setId("002");
		teacher1.setName("wb");
		teacher1.setStudents(getStudent2s());
		List<Teacher> lists = new ArrayList<Teacher>();
		lists.add(teacher);
		lists.add(teacher1);
		return lists;
	}
	
	public static List<Student> getStudent1s(){
		Student student = new Student();
		student.setName("lxl");
		student.setSid("1");
		Student student1 = new Student();
		student1.setName("mzy");
		student1.setSid("2");
		List<Student> lists = new ArrayList<Student>();
		lists.add(student);
		lists.add(student1);
		return lists;
	}
	
	public static List<Student> getStudent2s(){
		Student student = new Student();
		student.setName("lyc");
		student.setSid("3");
		Student student1 = new Student();
		student1.setName("zjl");
		student1.setSid("4");
		List<Student> lists = new ArrayList<Student>();
		lists.add(student);
		lists.add(student1);
		return lists;
	}
	
	public static List<String> initData() {
		List<String> lists = new ArrayList<String>();

		lists.add("abc");
		lists.add("def");
		lists.add("ghi");
		return lists;
	}
}
