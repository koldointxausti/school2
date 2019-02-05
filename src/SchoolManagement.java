import java.util.Scanner;
import com.zubiri.*;

public class SchoolManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		School school = new School();
		boolean repeat = true;
		while (repeat) {
			System.out.println("Welcome to school management program.\nWhat do you want to do?\n"
					+ "1- Manage teachers \n2- Manage students\n3- Manage administratives\n0-Exit\n");
			String option = sc.next();
			sc.nextLine();
			switch (option) {
			default:
				System.out.println("Enter a number, try again.");
				break;
			case "0": // stop the program
				System.out.println("Bye!");
				repeat = false;
				break;
				
				/* THIS IS NOT USEFULL BECAUSE THERE'S NOT A SCHOOLNAME PROPERTY
			case "1": // change school name
				System.out.println("Enter the name you want for your school.");
				school.setSchoolName(sc.nextLine());
				System.out.println("Done.");
				break;
				*/
//TEACHERS
			case "1":
				boolean teachersRepeat = true;
				while (teachersRepeat) {
					System.out.println("Welcome to Teachers management option. What do you want?");
					System.out.println(
							" 1- List teachers IDs\n 2- View Information\n 3- Modify Information\n 4- Delete Information\n 5- New Teacher\n 0- Go back");
					String teacherOption = sc.next();
					sc.nextLine();
					switch (teacherOption) {
					default:
						System.out.println("Enter a possible option.");
						break;
					case "0":
						teachersRepeat = false;
						break;
					case "1":
						if (school.getTeachers().size() > 0) {
							for (int i = 0; i < school.getTeachers().size(); i++) {
								//we think it would be more useful using the getTeachers().get() entering the index we want (instead of the name)
								System.out.println("- " + school.getTeachers().get(i).getTeacherID() + "\t"
										+ school.getTeachers().get(i).getName());
							}
						} else
							System.out.println("There's no teacher created yet.");
						break;
					case "2": // view teachers info
						if (school.getTeachers().size() > 0) {
							System.out.println(
									"Whose information do you want to view? (Enter the ID of the Teacher you want to find)");
							int teacherIndex = school.findTeacherID(sc.next().toUpperCase());
							sc.nextLine();
							System.out.println(teacherIndex);
							if (teacherIndex >= 0) {
								System.out.println("Name:\t" + school.getTeachers().get(teacherIndex).getName());
								System.out.println("Birth date:\t" + school.getTeachers().get(teacherIndex).getBirthDate());
								System.out.println("Dni:\t" + school.getTeachers().get(teacherIndex).getDni());
								System.out
										.println("Phone number:\t " + school.getTeachers().get(teacherIndex).getTelephone());
								System.out.println("Salary:\t " + school.getTeachers().get(teacherIndex).getSalary());
								System.out.println("Joined date:\t" + school.getTeachers().get(teacherIndex).getJoinedDate());
					//	why isTutor returns a string instead of boolean
								if (school.getTeachers().get(teacherIndex).isTutor().matches("true"))
									System.out.println("Tutor of:\t" + school.getTeachers().get(teacherIndex).getTutor());
								for (int i = 0; i < school.getTeachers().get(teacherIndex).getSubjects().size(); i++)
									System.out.println("Subjects:\t" + school.getTeachers().get(teacherIndex).getSubjects().get(i));
							} else
								System.out.println("Wrong teacher ID");
						} else
							System.out.println("There's no Teacher created yet.");
						break;
					case "3":// modify information
						if (school.getTeachers().size() > 0) {
							System.out.println(
									"Whose information do you want to modify? (Enter the ID of the Teacher you want to find)");
							int teacherIndex = school.findTeacherID(sc.next().toUpperCase());
							sc.nextLine();
							if (teacherIndex >= 0) {
								boolean modifyRepeat = true;
								while (modifyRepeat) {
									System.out.println("What do you want to modify?");
									// there's no option of changing the joined date
									System.out.println(
											"1-\tName\n2-\tBirth date\n3-\tDni\n4-\tPhone Number\n5-\tSalary\n6-\tSubjects\n0-\tGo back");
									String modifyOption = sc.next();
									sc.nextLine();
									switch (modifyOption) {
									default:
										System.out.println("Enter a valid option.");
										break;
									case "0":
										modifyRepeat = false;
										break;
									case "1": // name
										System.out.println(
												"Your actual name is " + school.getTeachers().get(teacherIndex).getName()
														+ "\nEnter the new name bellow:");
										String possibleName = sc.next();
										sc.nextLine();
							// there's no checking for the name
										school.getTeachers().get(teacherIndex).setName(possibleName);
										System.out.println("Done.");
										break;
									case "2": // birth date
										System.out.println("Your actual birth date is " + school.getTeachers().get(teacherIndex).getBirthDate()
												+ "\nEnter the new birth date bellow:");
										System.out.println("year:");
										int year = sc.nextInt();
										System.out.println("month:");
										int month = sc.nextInt();
										System.out.println("day:");
										int day = sc.nextInt();
										String birthDate= year+"/"+month+"/"+day;
							// we don't know the format it asks for the date
										while (!school.getTeachers().get(teacherIndex).isValidDate(birthDate)) {
											System.out.println("Enter a valid date");
											System.out.println("year:");
											year = sc.nextInt();
											System.out.println("month:");
											month = sc.nextInt();
											System.out.println("day:");
											day = sc.nextInt();
											birthDate = year+"/"+month+"/"+day;
										}
										school.getTeachers().get(teacherIndex).setBirthDate(birthDate);
										System.out.println("Done.");
										break;
									case "3": // dni
										System.out.println(
												"Your actual dni is " + school.getTeachers().get(teacherIndex).getDni()
														+ "\nEnter the new dni bellow:");
										String dni = sc.next();
										sc.nextLine();
										while (!school.getTeachers().get(teacherIndex).isValidDni(dni)) {
											System.out.println("Enter a valid DNI");
											dni = sc.next();
											sc.nextLine();
										}
										school.getTeachers().get(teacherIndex).setDni(dni);
										System.out.println("Done.");
										break;
									case "4": // phone number
										System.out.println("Your actual phone number is "
												+ school.getTeachers().get(teacherIndex).getTelephone()
												+ "\nEnter the new phone number bellow:");
										String phoneNumber = sc.next();
										sc.nextLine();
										while (!school.getTeachers().get(teacherIndex).isValidTelephone(phoneNumber)) {
											System.out.println("Enter a valid phone number");
											phoneNumber = sc.next();
											sc.nextLine();
										}
										school.getTeachers().get(teacherIndex).setTelephone(phoneNumber);
										System.out.println("Done.");
										break;
									case "5": // salary
										//There is not a checksalary method
										System.out.println(
												"Your actual salary is " + school.getTeachers().get(teacherIndex).getSalary()
														+ "\nEnter the new salary bellow:");
										double salary = sc.nextDouble();
										while (salary < 0) {
											System.out.println("Enter a valid salary");
											salary = sc.nextDouble();
										}
										school.getTeachers().get(teacherIndex).setSalary(salary);
										System.out.println("Done.");
										break;
									case "6": // subjects
										System.out.println("Your actual subjects are ");
										for (int i = 0; i < school.getTeachers().get(teacherIndex).getSubjects().size(); i++)
											System.out.println("\t" + school.getTeachers().get(teacherIndex).getSubjects().get(i));
										System.out.println("How many subjects are you teaching now?");
										int numberOfSubjects = sc.nextInt();
										for (int i = 0; i < numberOfSubjects; i++) {
											System.out.println("enter one subject");
											school.getTeachers().get(teacherIndex).addSubject(sc.next());
											sc.nextLine();
										}
										break;
									}
								}
							} else
								System.out.println("Wrong teacher ID");
						} else
							System.out.println("There's no Teacher created yet.");
						break;
					case "4": // delete info
						if (school.getTeachers().size() > 0) {
							System.out.println(
									"Whose information do you want to delete? (Enter the ID of the Teacher you want to find)");
							int teacherIndex = school.findTeacherID(sc.next().toUpperCase());
							sc.nextLine();
							if (teacherIndex >= 0) {
								school.deleteTeacher(school.getTeachers().get(teacherIndex).getName());
								System.out.println("Done.");
							} else
								System.out.println("Wrong teacher ID");
						} else
							System.out.println("There's no Teacher created yet.");
						break;
					case "5": // new teacher
						System.out.println("*NEW TEACHER*");
						Teacher teacher = new Teacher();
						// name
						System.out.println("Name:");
						String possibleName = sc.next();
						sc.nextLine();
						//There is no matchname
						while (possibleName.matches("^[A-Za-z]+")) {
							System.out.println("Enter a valid name (no numbers)");
							possibleName = sc.next();
							sc.nextLine();
						}
						teacher.setName(possibleName);

						// birth date
						System.out.println("Birth date:");
						System.out.println("year:");
						int year = sc.nextInt();
						System.out.println("month:");
						int month = sc.nextInt();
						System.out.println("day:");
						int day = sc.nextInt();
						String birthDate= year+"/"+month+"/"+day;
						
						//We dont know the format
						while (!teacher.isValidDate(birthDate)) {
							System.out.println("Enter a valid date");
							System.out.println("year:");
							year = sc.nextInt();
							System.out.println("month:");
							month = sc.nextInt();
							System.out.println("day:");
							day = sc.nextInt();
							birthDate= year+"/"+month+"/"+day;
						}
						teacher.setBirthDate(birthDate);

						// dni
						System.out.println("DNI:");
						String dni = sc.next();
						sc.nextLine();
						while (!teacher.isValidDni(dni)) {
							System.out.println("Enter a valid DNI");
							dni = sc.next();
							sc.nextLine();
						}
						teacher.setDni(dni);

						// phone number
						System.out.println("Telephone number:");
						String phoneNumber = sc.next();
						sc.nextLine();
						while (!teacher.isValidTelephone(phoneNumber)) {
							System.out.println("Enter a valid phone number");
							phoneNumber = sc.next();
							sc.nextLine();
						}
						teacher.setTelephone(phoneNumber);

						// salary
						System.out.println("Salary:");
						double salary = sc.nextDouble();
						while (salary < 0) {
							System.out.println("Enter a valid salary");
							salary = sc.nextDouble();
						}
						teacher.setSalary(salary);

						// joined date
						System.out.println("Joined date");
						System.out.println("year:");
						year = sc.nextInt();
						System.out.println("month:");
						month = sc.nextInt();
						System.out.println("day:");
						day = sc.nextInt();
						String joined = year+"/"+month+"/"+day;
						while (!teacher.isValidDate(joined)) {
							System.out.println("Enter a valid date");
							System.out.println("year:");
							year = sc.nextInt();
							System.out.println("month:");
							month = sc.nextInt();
							System.out.println("day:");
							day = sc.nextInt();
							joined = joined = year+"/"+month+"/"+day;
						}
						teacher.setJoinedDate(joined);

						// tutor
						System.out.println("Is she/he a tutor? (y/n)");
						boolean askAgain = true;
						while (askAgain == true) {
							String back = sc.next().toLowerCase();
							sc.nextLine();
							switch (back) {
							case "y": // if he|she is tutor ask for the classroom
								System.out.println("What class is she/he tutor of?");
								teacher.setTutor(sc.next());
								sc.nextLine();
								askAgain = false;
								break;
							case "n":
								askAgain = false;
								break;
							default:
								System.out.println("Please, select a possible value(y/n)");
								break;
							}
						}

						// subjects
						System.out.println("How many subjects do she/he teach?");
						int numberOfSubjects = sc.nextInt();
						for (int i = 0; i < numberOfSubjects; i++) {
							System.out.println("enter one subject");
							teacher.addSubject(sc.next());
							sc.nextLine();
						}

						// add the teacher to the school
						school.addTeacher(teacher);
						// print the created ID for the teacher
						System.out.println("The ID of " + teacher.getName() + " is " + teacher.getTeacherID());
						break;
					}
				}
				break;

//STUDENTS
			case "2":
				boolean studentsRepeat = true;
				while (studentsRepeat) {
					System.out.println("Welcome to Students management option. What do you want?");
					System.out.println(
							" 1- List students IDs\n 2- View Information\n 3- Modify Information\n 4- Delete Information\n 5- New Student\n 6- Tutor\n 0- Go back");
					String studentOption = sc.next();
					sc.nextLine();
					switch (studentOption) {
					default:
						System.out.println("Enter a possible option.");
						break;
					case "0":// go back
						studentsRepeat = false;
						break;
					case "1":// list IDs
						if (school.getStudents().size() > 0) {
							for (int i = 0; i < school.getStudents().size(); i++) {
								System.out.println("- " + school.getStudents().get(i).getStudentID() + "\t"
										+ school.getStudents().get(i).getName());
							}
						} else
							System.out.println("There's no student created yet.");
						break;
					case "2": // view students info
						if (school.getStudents().size() > 0) {
							System.out.println(
									"Whose information do you want to view? (Enter the ID of the Student you want to find)");
							int studentIndex = school.findStudentID(sc.next().toUpperCase());
							sc.nextLine();
							System.out.println(studentIndex);
							if (studentIndex >= 0) {
								System.out.println("Name:\t" + school.getStudents().get(studentIndex).getName());
								String date = school.getStudents().get(studentIndex).getBirthDate();
								System.out.println("Birth date:\t" + date);
								System.out.println("Dni:\t" + school.getStudents().get(studentIndex).getDni());
								System.out
										.println("Phone number:\t " + school.getStudents().get(studentIndex).getTelephone());
								System.out.println("Absenses:\t" + school.getStudents().get(studentIndex).getAbsenses());
								System.out.println("Classroom:\t" + school.getStudents().get(studentIndex).getClassroom());
								System.out
										.println("Mark average:\t" + school.getStudents().get(studentIndex).getMarkAverage());
								/*
								//There is no course get method
								System.out.println("Course:\t" + school.getStudents().get(studentIndex).getCourse());
								//There is no repeter get method
								if (school.getStudent(studentIndex).getRepeater())
									System.out.println("Has repeated at leat one course.");
									
									*/
							} else
								System.out.println("Wrong student ID");
						} else
							System.out.println("There's no Student created yet.");
						break;
					case "3":// modify information
						if (school.getStudents().size() > 0) {
							System.out.println(
									"Whose information do you want to modify? (Enter the ID of the Student you want to find)");
							int studentIndex = school.findStudentID(sc.next().toUpperCase());
							sc.nextLine();
							if (studentIndex >= 0) {
								boolean modifyRepeat = true;
								while (modifyRepeat) {
									System.out.println("What do you want to modify?");
									// there's no option of changing the joined date
									System.out.println(
											"1-\tName\n2-\tBirth date\n3-\tDni\n4-\tPhone Number\n5-\tAbsenses\n6-\tClassroom\n7-\tMark Average\n8-\tCourse\n9.\tHas repeated?\n0-\tGo back");
									String modifyOption = sc.next();
									sc.nextLine();
									switch (modifyOption) {
									default:
										System.out.println("Enter a valid option.");
										break;
									case "0":
										modifyRepeat = false;
										break;
									case "1": // name
										System.out.println(
												"Your actual name is " + school.getStudents().get(studentIndex).getName()
														+ "\nEnter the new name bellow:");
										String possibleName = sc.next();
										sc.nextLine();
										
										school.getStudents().get(studentIndex).setName(possibleName);
										System.out.println("Done.");
										break;
									case "2": // birth date
										
										System.out.println("Your actual birth date is " + school.getStudents().get(studentIndex).getBirthDate()
												+ "\nEnter the new birth date bellow:");
										System.out.println("year:");
										int year = sc.nextInt();
										System.out.println("month:");
										int month = sc.nextInt();
										System.out.println("day:");
										int day = sc.nextInt();
										String birthDate = year+"/"+month+"/"+day;
										while (!school.getStudents().get(studentIndex).isValidDate(birthDate)) {
											System.out.println("Enter a valid date");
											System.out.println("year:");
											year = sc.nextInt();
											System.out.println("month:");
											month = sc.nextInt();
											System.out.println("day:");
											day = sc.nextInt();
											birthDate = year+"/"+month+"/"+day;
										}
										school.getStudents().get(studentIndex).setBirthDate(birthDate);
										System.out.println("Done.");
										break;
									case "3": // dni
										System.out.println(
												"Your actual dni is " + school.getStudents().get(studentIndex).getDni()
														+ "\nEnter the new dni bellow:");
										String dni = sc.next();
										sc.nextLine();
										while (!school.getStudents().get(studentIndex).isValidDni(dni)) {
											System.out.println("Enter a valid DNI");
											dni = sc.next();
											sc.nextLine();
										}
										school.getStudents().get(studentIndex).setDni(dni);
										System.out.println("Done.");
										break;
									case "4": // phone number
										System.out.println("Your actual phone number is "
												+ school.getStudents().get(studentIndex).getTelephone()
												+ "\nEnter the new phone number bellow:");
										String phoneNumber = sc.next();
										sc.nextLine();
										while (!school.getStudents().get(studentIndex).isValidTelephone(phoneNumber)) {
											System.out.println("Enter a valid phone number");
											phoneNumber = sc.next();
											sc.nextLine();
										}
										school.getStudents().get(studentIndex).setTelephone(phoneNumber);
										System.out.println("Done.");
										break;
									case "5": // absenses
										System.out.println("Your actual number of asenses is "
												+ school.getStudents().get(studentIndex).getAbsenses()
												+ "\nEnter the new number of asenses bellow:");
										boolean keepAsking = true;
										while (keepAsking) {
											if (sc.hasNextInt()) {
												school.getStudents().get(studentIndex).setAbsenses(sc.nextInt());
												keepAsking = false;
											} else
												System.out.println("Enter a valid value");
										}
										System.out.println("Done.");
										break;
									case "6": // classroom
										System.out.println("Your actual classroom is "
												+ school.getStudents().get(studentIndex).getClassroom()
												+ "\nEnter the new classroom bellow:");
										school.getStudents().get(studentIndex).setClassroom(sc.next());
										sc.nextLine();
										System.out.println("Done.");
										break;
									case "7": // markAverage
										System.out.println("Your actual mark average is "
												+ school.getStudents().get(studentIndex).getMarkAverage()
												+ "\nEnter the new mark average bellow:");
										keepAsking = true;
										while (keepAsking) {
											if (sc.hasNextInt()) {
												school.getStudents().get(studentIndex).setMarkAverage(sc.nextInt());
												keepAsking = false;
											} else
												System.out.println("Enter a valid value");
										}
										System.out.println("Done.");
										break;
									case "8": // course
										
										//There is not a course property
										/*
										System.out.println(
												"Your actual course is " + school.getStudents().get(studentIndex).getCourse()
														+ "\nEnter the new course bellow:");
										keepAsking = true;
										while (keepAsking) {
											if (sc.hasNextInt()) {
												school.getStudent(studentIndex).setCourse(sc.nextInt());
												keepAsking = false;
											} else
												System.out.println("Enter a valid value");
										}
										System.out.println("Done.");
										*/
										break;
									case "9":
										
										//There is not a repeater property
										/*
										if (school.getStudent(studentIndex).getRepeater())
											System.out.print("You are suposed to be a repeater now,");
										else
											System.out.print("You are not suposed to be a repeater now,");
										System.out.print(" have you repeated?(y/n)");
										boolean askAgain = true;
										while (askAgain) {
											String repeaterOption = sc.next();
											sc.nextLine();
											switch (repeaterOption) {
											case "y":
												school.getStudent(studentIndex).setRepeater(true);
												askAgain = false;
												System.out.println("Done.");
												break;
											case "n":
												askAgain = false;
												System.out.println("Done.");
												break;
											default:
												System.out.println("Enter 'y' for yes or 'n' for no");
												break;
											}
										}
										*/
										break;
									}
								}
							} else
								System.out.println("Wrong student ID");
						} else
							System.out.println("There's no Student created yet.");
						break;
					case "4": // delete info
						if (school.getStudents().size() > 0) {
							System.out.println(
									"Whose information do you want to delete? (Enter the ID of the Student you want to find)");
							int studentIndex = school.findStudentID(sc.next().toUpperCase());
							sc.nextLine();
							if (studentIndex >= 0) {
								school.deleteTeacher(school.getStudents().get(studentIndex).getName());
								System.out.println("Done.");
							} else
								System.out.println("Wrong student ID");
						} else
							System.out.println("There's no Student created yet.");
						break;
					case "5": // new student
						System.out.println("*NEW STUDENT*");
						Student student = new Student();
						// name
						System.out.println("Name:");
						String possibleName = sc.next();
						sc.nextLine();
						/*
						while (!student.checkName(possibleName)) {
							System.out.println("Enter a valid name (no numbers)");
							possibleName = sc.next();
							sc.nextLine();
						}
						*/
						student.setName(possibleName);

						// birth date
						System.out.println("Birth date:");
						System.out.println("year:");
						int year = sc.nextInt();
						System.out.println("month:");
						int month = sc.nextInt();
						System.out.println("day:");
						int day = sc.nextInt();
						String birthDate = year+"/"+month+"/"+day;
						while (!student.isValidDate(birthDate)) {
							System.out.println("Enter a valid date");
							System.out.println("year:");
							year = sc.nextInt();
							System.out.println("month:");
							month = sc.nextInt();
							System.out.println("day:");
							day = sc.nextInt();
							birthDate = year+"/"+month+"/"+day;
						}
						student.setBirthDate(birthDate);

						// dni
						System.out.println("DNI:");
						String dni = sc.next();
						sc.nextLine();
						while (!student.isValidDni(dni)) {
							System.out.println("Enter a valid DNI");
							dni = sc.next();
							sc.nextLine();
						}
						student.setDni(dni);

						// phone number
						System.out.println("Telephone number:");
						String phoneNumber = sc.next();
						sc.nextLine();
						while (!student.isValidTelephone(phoneNumber)) {
							System.out.println("Enter a valid phone number");
							phoneNumber = sc.next();
							sc.nextLine();
						}
						student.setTelephone(phoneNumber);

						// absenses
						System.out.println("Absenses:");
						boolean keepAsking = true;
						while (keepAsking) {
							if (sc.hasNextInt()) {
								student.setAbsenses(sc.nextInt());
								keepAsking = false;
							} else
								System.out.println("Enter a valid value");
						}
						// classroom
						System.out.println("Classroom:");
						student.setClassroom(sc.next());
						sc.nextLine();

						// mark average
						System.out.println("Mark average:");
						keepAsking = true;
						while (keepAsking) {
							if (sc.hasNextInt()) {
								student.setMarkAverage(sc.nextInt());
								keepAsking = false;
							} else
								System.out.println("Enter a valid value");
						}

						// course
						/*
						System.out.println("Course:");
						keepAsking = true;
						while (keepAsking) {
							if (sc.hasNextInt()) {
								student.setCourse(sc.nextInt());
								keepAsking = false;
							} else
								System.out.println("Enter a valid value");
						}
*/
						// repeater
						/*
						System.out.println("Are you a repeater? (y/n)");
						boolean askAgain = true;
						while (askAgain) {
							String repeaterOption = sc.next();
							sc.nextLine();
							switch (repeaterOption) {
							case "y":
								student.setRepeater(true);
								askAgain = false;
								break;
							case "n":
								askAgain = false;
								break;
							default:
								System.out.println("Enter 'y' for yes or 'n' for no");
								break;
							}
						}
*/
						// add the student to the school
						school.addStudent(student);
						// print the created ID for the student
						System.out.println("The ID of " + student.getName() + " is " + student.getStudentID());
						break;
					case "6": //tutor
						if (school.getStudents().size() > 0) {
							System.out.println(
									"Whose tutor do you want to know? (Enter the ID of the Student you want to find)");
							int studentIndex = school.findStudentID(sc.next().toUpperCase());
							sc.nextLine();
							
							if (studentIndex >= 0) {
								int tutorIndex=-1;
								for(int i=0; i<school.getTeachers().size();i++) {
									if(school.getStudents().get(studentIndex).getClassroom().matches(school.getTeachers().get(i).getTutor())){
										tutorIndex=i;
										break;
									}
								}
								if (tutorIndex >= 0)
									System.out.println("The tutor of " + school.getStudents().get(studentIndex).getName()
											+ " is " + school.getTeachers().get(tutorIndex).getName()+", "+school.getTeachers().get(tutorIndex).getTeacherID());
								else
									System.out.println("That class has not tutor assigned");
								break;
							}
						} else
							System.out.println("No Student created yet.");
						break;
					}

				}
				break;

//ADMINISTRATIVES

			case "3":
				boolean administrativesRepeat = true;
				while (administrativesRepeat) {
					System.out.println("Welcome to Administratives management option. What do you want?");
					System.out.println(
							" 1- List administratives IDs\n 2- View Information\n 3- Modify Information\n 4- Delete Information\n 5- New Administrative\n 0- Go back");
					String administrativeOption = sc.next();
					sc.nextLine();
					switch (administrativeOption) {
					default:
						System.out.println("Enter a possible option.");
						break;
					case "0":
						administrativesRepeat = false;
						break;
					case "1":
						if (school.getAdministratives().size() > 0) {
							for (int i = 0; i < school.getAdministratives().size(); i++) {
								System.out.println("- " + school.getAdministratives().get(i).getAdministrativeID() + "\t"
										+ school.getAdministratives().get(i).getName());
							}
						} else
							System.out.println("There's no administrative created yet.");
						break;
					case "2": // view administratives info
						if (school.getAdministratives().size() > 0) {
							System.out.println(
									"Whose information do you want to view? (Enter the ID of the Administrative you want to find)");
							int administrativeIndex = school.findAdministrativeID(sc.next().toUpperCase());
							sc.nextLine();
							System.out.println(administrativeIndex);
							if (administrativeIndex >= 0) {
								System.out.println("Name:\t" + school.getAdministratives().get(administrativeIndex).getName());
								System.out.println("Birth date:\t" + school.getAdministratives().get(administrativeIndex).getBirthDate());
								System.out.println("Dni:\t" + school.getAdministratives().get(administrativeIndex).getDni());
								System.out.println("Phone number:\t "
										+ school.getAdministratives().get(administrativeIndex).getTelephone());
								System.out.println(
										"Salary:\t " + school.getAdministratives().get(administrativeIndex).getSalary());
								System.out.println("Joined date:\t" + school.getAdministratives().get(administrativeIndex).getJoinedDate());
								if (school.getAdministratives().get(administrativeIndex).getLanguages().size() > 0)
									for (int i = 0; i < school.getAdministratives().get(administrativeIndex)
											.getLanguages().size(); i++)
										System.out.println(
												school.getAdministratives().get(administrativeIndex).getLanguages().get(i));
							} else
								System.out.println("Wrong administrative ID");
						} else
							System.out.println("There's no Administrative created yet.");
						break;
					case "3":// modify information
						if (school.getAdministratives().size() > 0) {
							System.out.println(
									"Whose information do you want to modify? (Enter the ID of the Administrative you want to find)");
							int administrativeIndex = school.findAdministrativeID(sc.next().toUpperCase());
							sc.nextLine();
							if (administrativeIndex >= 0) {
								boolean modifyRepeat = true;
								while (modifyRepeat) {
									System.out.println("What do you want to modify?");
									// there's no option of changing the joined date
									System.out.println(
											"1-\tName\n2-\tBirth date\n3-\tDni\n4-\tPhone Number\n5-\tSalary\n6-\tLanguages\n0-\tGo back");
									String modifyOption = sc.next();
									sc.nextLine();
									switch (modifyOption) {
									default:
										System.out.println("Enter a valid option.");
										break;
									case "0":
										modifyRepeat = false;
										break;
									case "1": // name
										System.out.println("Your actual name is "
												+ school.getAdministratives().get(administrativeIndex).getName()
												+ "\nEnter the new name bellow:");
										String possibleName = sc.next();
										sc.nextLine();
										school.getAdministratives().get(administrativeIndex).setName(possibleName);
										System.out.println("Done.");
										break;
									case "2": // birth date
										System.out.println("Your actual birth date is " + school.getAdministratives().get(administrativeIndex).getBirthDate()
												+ "\nEnter the new birth date bellow:");
										System.out.println("year:");
										int year = sc.nextInt();
										System.out.println("month:");
										int month = sc.nextInt();
										System.out.println("day:");
										int day = sc.nextInt();
										String birthDate = year+"/"+month+"/"+day;
										while (!school.getStudents().get(administrativeIndex).isValidDate(birthDate)) {
											System.out.println("Enter a valid date");
											System.out.println("year:");
											year = sc.nextInt();
											System.out.println("month:");
											month = sc.nextInt();
											System.out.println("day:");
											day = sc.nextInt();
											birthDate = year+"/"+month+"/"+day;
										}
										school.getStudents().get(administrativeIndex).setBirthDate(birthDate);
										System.out.println("Done.");
										break;
									case "3": // dni
										System.out.println("Your actual dni is "
												+ school.getAdministratives().get(administrativeIndex).getDni()
												+ "\nEnter the new dni bellow:");
										String dni = sc.next();
										sc.nextLine();
										while (!school.getAdministratives().get(administrativeIndex).isValidDni(dni)) {
											System.out.println("Enter a valid DNI");
											dni = sc.next();
											sc.nextLine();
										}
										school.getAdministratives().get(administrativeIndex).setDni(dni);
										System.out.println("Done.");
										break;
									case "4": // phone number
										System.out.println("Your actual phone number is "
												+ school.getAdministratives().get(administrativeIndex).getTelephone()
												+ "\nEnter the new phone number bellow:");
										String phoneNumber = sc.next();
										sc.nextLine();
										while (!school.getAdministratives().get(administrativeIndex)
												.isValidTelephone(phoneNumber)) {
											System.out.println("Enter a valid phone number");
											phoneNumber = sc.next();
											sc.nextLine();
										}
										school.getAdministratives().get(administrativeIndex).setTelephone(phoneNumber);
										System.out.println("Done.");
										break;
									case "5": // salary
										System.out.println("Your actual salary is "
												+ school.getAdministratives().get(administrativeIndex).getSalary()
												+ "\nEnter the new salary bellow:");
										double salary = sc.nextDouble();
										school.getAdministratives().get(administrativeIndex).setSalary(salary);
										System.out.println("Done.");
										break;
									case "6": // languages
										System.out.println("Your actual languages are ");
										for (int i = 0; i < school.getAdministratives().get(administrativeIndex)
												.getLanguages().size(); i++)
											System.out.println("\t"
													+ school.getAdministratives().get(administrativeIndex).getLanguages().get(i));
										System.out.println("How many subjects are you teaching now?");
										int numberOfLanguages = sc.nextInt();
										String[] languages = new String[numberOfLanguages];
										for (int i = 0; i < numberOfLanguages; i++) {
											System.out.println("enter one language");
											school.getAdministratives().get(administrativeIndex)
											.addLanguage(sc.next()); 
											sc.nextLine();

										}
										break;
									}
								}
							} else
								System.out.println("Wrong administrative ID");
						} else
							System.out.println("There's no Administrative created yet.");
						break;
					case "4": // delete info
						if (school.getAdministratives().size() > 0) {
							System.out.println(
									"Whose information do you want to delete? (Enter the ID of the Administrative you want to find)");
							int administrativeIndex = school.findAdministrativeID(sc.next().toUpperCase());
							sc.nextLine();
							if (administrativeIndex >= 0) {
								school.deleteAdministrative(school.getAdministratives().get(administrativeIndex).getName());
								System.out.println("Done.");
							} else
								System.out.println("Wrong administrative ID");
						} else
							System.out.println("There's no Administrative created yet.");
						break;
					case "5": // new administrative
						System.out.println("*NEW TEACHER*");
						Administrative administrative = new Administrative();
						// name
						System.out.println("Name:");
//there's no method for the checking of the name
						String possibleName = sc.next();
						sc.nextLine();
						administrative.setName(possibleName);

						// birth date
						System.out.println("Birth date:");
						System.out.println("year:");
						int year = sc.nextInt();
						System.out.println("month:");
						int month = sc.nextInt();
						System.out.println("day:");
						int day = sc.nextInt();
						String birthDate = year+"/"+month+"/"+year;
						while (!administrative.isValidDate(birthDate)) {
							System.out.println("Enter a valid date");
							System.out.println("year:");
							year = sc.nextInt();
							System.out.println("month:");
							month = sc.nextInt();
							System.out.println("day:");
							day = sc.nextInt();
							birthDate = year+"/"+month+"/"+year;
						}
						administrative.setBirthDate(birthDate);

						// dni
						System.out.println("DNI:");
						String dni = sc.next();
						sc.nextLine();
						while (!administrative.isValidDni(dni)) {
							System.out.println("Enter a valid DNI");
							dni = sc.next();
							sc.nextLine();
						}
						administrative.setDni(dni);

						// phone number
						System.out.println("Telephone number:");
						String phoneNumber = sc.next();
						sc.nextLine();
						while (!administrative.isValidTelephone(phoneNumber)) {
							System.out.println("Enter a valid phone number");
							phoneNumber = sc.next();
							sc.nextLine();
						}
						administrative.setTelephone(phoneNumber);

						// salary
						System.out.println("Salary:");
						double salary = sc.nextDouble();
						administrative.setSalary(salary);

						// joined date
						System.out.println("Joined date");
						System.out.println("year:");
						year = sc.nextInt();
						System.out.println("month:");
						month = sc.nextInt();
						System.out.println("day:");
						day = sc.nextInt();
						String joined = year+"/"+month+"/"+year;
						while (!administrative.isValidDate(joined)) {
							System.out.println("Enter a valid date");
							System.out.println("year:");
							year = sc.nextInt();
							System.out.println("month:");
							month = sc.nextInt();
							System.out.println("day:");
							day = sc.nextInt();
							joined = year+"/"+month+"/"+year;
						}
						administrative.setJoinedDate(joined);

						// languages
						System.out.println("Languages:");
						System.out.println("How many languages are you teaching now?");
						int numberOfLanguages = sc.nextInt();
						for (int i = 0; i < numberOfLanguages; i++) {
							System.out.println("enter one language");
							String language = sc.next();
							sc.nextLine();
							administrative.addLanguage(language);
						}
						
						//add the administrative to the school
						school.addAdministrative(administrative);
						System.out.println("The ID of " + administrative.getName() + " is " + administrative.getAdministrativeID());
					}
				}
				break;
			}

		}
		sc.close();
	}

}