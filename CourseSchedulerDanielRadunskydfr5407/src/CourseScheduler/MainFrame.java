package CourseScheduler;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acv
 */
public class MainFrame extends javax.swing.JFrame {

    private String currentSemester;
    private StudentEntry currentStudent;

    public MainFrame() {
        initComponents();
        rebuildSemesterComboBoxes();
        rebuildCourseComboBoxes();
        rebuildStudentComboBoxes();
    }

    private void rebuildSemesterComboBoxes() {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel(semesters.toArray()));
        if (semesters.size() > 0) {
            currentSemesterLabel.setText(semesters.get(0));
            currentSemester = semesters.get(0);
        } else {
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
    }

    private void rebuildCourseComboBoxes() {
        selectCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel(CourseQueries.getAllCourseCodes(currentSemester).toArray()));
        courseListAdminCoursesComboBox.setModel(new javax.swing.DefaultComboBoxModel(CourseQueries.getAllCourseCodes(currentSemester).toArray()));
        dropCoursesComboBox.setModel(new javax.swing.DefaultComboBoxModel(CourseQueries.getAllCourseCodes(currentSemester).toArray()));
    }

    private void rebuildStudentComboBoxes() {
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
        String[] nameArray = new String[students.size()];
        int i = 0;

        for (StudentEntry student : students) {
            nameArray[i] = student.getLastName() + ", " + student.getFirstName() + " " + student.getStudentID();
            i++;
        }

        globalStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(nameArray));
        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(nameArray));

        if (!students.isEmpty()) {
            currentStudent = students.get(0);
            currentStudentLabel.setText(currentStudent.ID());
            rebuildCurrentStudentCourseComboBox();
        }
    }

    private void rebuildCurrentStudentCourseComboBox() {
        ArrayList<ScheduleEntry> courses = ScheduleQueries.getScheduleByStudent(currentSemester, currentStudent.getStudentID());
        String[] courseArray = new String[courses.size()];
        int i = 0;
        for (ScheduleEntry course : courses) {
            courseArray[i] = course.getCourseCode();
            i++;
        }
        dropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel(courseArray));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        courseCodeEntry = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        courseDescriptionEntry = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        seatsEntry = new javax.swing.JSpinner();
        addCourseButton = new javax.swing.JButton();
        addCourseOutput = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        studentIDEntry = new javax.swing.JTextField();
        firstNameEntry = new javax.swing.JTextField();
        lastNameEntry = new javax.swing.JTextField();
        addStudentButton = new javax.swing.JButton();
        addStudentOutput = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        courseListAdminCoursesComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        displayCourseLists = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        waitlistedStudentsTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        scheduledStudentsTable = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        dropStudentComboBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        dropStudentButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        dropStudentTextArea = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        dropCoursesComboBox = new javax.swing.JComboBox<>();
        dropCourseButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        dropCourseTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coursesTable = new javax.swing.JTable();
        displayCoursesButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        selectCourseComboBox = new javax.swing.JComboBox<>();
        scheduleCoursesButton = new javax.swing.JButton();
        scheduleCourseOutput = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayScheduleTable = new javax.swing.JTable();
        displayScheduleButton = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        dropCourseComboBox = new javax.swing.JComboBox<>();
        dropCourseStudent = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        dropCourseStudentTextArea = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        currentStudentLabel = new javax.swing.JLabel();
        globalStudentComboBox = new javax.swing.JComboBox<>();
        changeStudentGlobal = new javax.swing.JButton();
        currentSemesterDisplay = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Scheduler");

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setText("Semester Name:");

        addSemesterTextfield.setColumns(20);

        addSemesterSubmitButton.setText("Submit");
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        addSemesterStatusLabel.setText("                                                   ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addSemesterSubmitButton)
                            .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addSemesterSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(addSemesterStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Semester", jPanel3);

        jLabel4.setText("Course Code: ");

        jLabel5.setText("Course Description:");

        jLabel6.setText("Seats:");

        addCourseButton.setText("Submit");
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCourseButton)
                            .addComponent(courseCodeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseDescriptionEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatsEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addCourseOutput))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(courseCodeEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(courseDescriptionEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(seatsEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addCourseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addCourseOutput)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Course", jPanel4);

        jLabel7.setText("Student ID:");

        jLabel8.setText("First Name:");

        jLabel9.setText("Last Name:");

        addStudentButton.setText("Submit");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStudentButton)
                            .addComponent(lastNameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentIDEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addStudentOutput))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(studentIDEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(firstNameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lastNameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addStudentButton)
                .addGap(18, 18, 18)
                .addComponent(addStudentOutput)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Student", jPanel5);

        courseListAdminCoursesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Select Course:");

        displayCourseLists.setText("Display");
        displayCourseLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCourseListsActionPerformed(evt);
            }
        });

        jLabel13.setText("Waitlisted Students");

        waitlistedStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last Name", "First Name", "Student ID"
            }
        ));
        jScrollPane3.setViewportView(waitlistedStudentsTable);

        jLabel14.setText("Scheduled Students:");

        scheduledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last Name", "First Name", "Student ID"
            }
        ));
        jScrollPane4.setViewportView(scheduledStudentsTable);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(courseListAdminCoursesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayCourseLists)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseListAdminCoursesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(displayCourseLists))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        jTabbedPane2.addTab("Display Course List of Students", jPanel10);

        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Select Student:");

        dropStudentButton.setText("Drop Student");
        dropStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentButtonActionPerformed(evt);
            }
        });

        dropStudentTextArea.setColumns(20);
        dropStudentTextArea.setRows(5);
        jScrollPane5.setViewportView(dropStudentTextArea);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(dropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(dropStudentButton)))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(dropStudentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Student", jPanel11);

        jLabel16.setText("Select Course to be Dropped:");

        dropCoursesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropCourseButton.setText("Drop Course");
        dropCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropCourseButtonActionPerformed(evt);
            }
        });

        dropCourseTextArea.setColumns(20);
        dropCourseTextArea.setRows(5);
        jScrollPane6.setViewportView(dropCourseTextArea);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dropCoursesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(dropCourseButton)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(dropCoursesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropCourseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Course", jPanel12);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admin", jPanel1);

        coursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Code", "Description", "Seats"
            }
        ));
        jScrollPane1.setViewportView(coursesTable);

        displayCoursesButton.setText("Display");
        displayCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCoursesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(displayCoursesButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayCoursesButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Display Courses", jPanel6);

        jLabel10.setText("Select Course:");

        selectCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectCourseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCourseComboBoxActionPerformed(evt);
            }
        });

        scheduleCoursesButton.setText("Submit");
        scheduleCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleCoursesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scheduleCoursesButton)
                            .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scheduleCourseOutput))
                .addContainerGap(522, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(selectCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scheduleCoursesButton)
                .addGap(69, 69, 69)
                .addComponent(scheduleCourseOutput)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Schedule Courses", jPanel7);

        displayScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Code", "Status"
            }
        ));
        jScrollPane2.setViewportView(displayScheduleTable);

        displayScheduleButton.setLabel("Display");
        displayScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayScheduleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(displayScheduleButton)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayScheduleButton)
                .addGap(238, 238, 238))
        );

        jTabbedPane3.addTab("Display Schedule", jPanel8);

        jLabel11.setText("Select Course:");

        dropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropCourseStudent.setText("Drop Course");
        dropCourseStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropCourseStudentActionPerformed(evt);
            }
        });

        dropCourseStudentTextArea.setColumns(20);
        dropCourseStudentTextArea.setRows(5);
        jScrollPane7.setViewportView(dropCourseStudentTextArea);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dropCourseStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(320, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(dropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropCourseStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Drop Course", jPanel9);

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel17.setText("Current Student:");

        currentStudentLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        globalStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        changeStudentGlobal.setText("Change Student");
        changeStudentGlobal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeStudentGlobalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane3)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(globalStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changeStudentGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(globalStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeStudentGlobal))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(currentStudentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane3.getAccessibleContext().setAccessibleName("Display Courses");

        jTabbedPane1.addTab("Student", jPanel2);

        currentSemesterDisplay.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        currentSemesterDisplay.setText("Current Semester: ");

        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");

        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        currentSemesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentSemesterComboBoxActionPerformed(evt);
            }
        });

        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(currentSemesterDisplay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(changeSemesterButton)
                                .addGap(80, 80, 80)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentSemesterDisplay)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        String semester = addSemesterTextfield.getText();
        if (semester.length() > 0) {
            SemesterQueries.addSemester(semester);
            addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
            rebuildSemesterComboBoxes();
        }
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    private void selectCourseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
    }
    
    private void currentSemesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
    }
    
    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonActionPerformed
        // TODO add your handling code here:
        if (courseCodeEntry.getText().length() > 0 && courseDescriptionEntry.getText().length() > 0) {
            CourseEntry newCourseEntry = new CourseEntry(currentSemester, courseCodeEntry.getText(), courseDescriptionEntry.getText(), (int) seatsEntry.getValue());
            CourseQueries.addCourse(newCourseEntry);
            addCourseOutput.setText(courseCodeEntry.getText() + " has been added.");
            rebuildCourseComboBoxes();
            displayCoursesButtonActionPerformed(null);
        }
    }//GEN-LAST:event_addCourseButtonActionPerformed

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        // TODO add your handling code here:
        if (studentIDEntry.getText().length() > 0 && firstNameEntry.getText().length() > 0 && lastNameEntry.getText().length() > 0) {
            StudentEntry newStudent = new StudentEntry(studentIDEntry.getText(), firstNameEntry.getText(), lastNameEntry.getText());
            StudentQueries.addStudent(newStudent);
            addStudentOutput.setText(lastNameEntry.getText() + ", " + firstNameEntry.getText() + " has been added");
            rebuildStudentComboBoxes();
        }

    }//GEN-LAST:event_addStudentButtonActionPerformed

    // STUDENT-DISPLAY_COURSES TABLE
    private void displayCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCoursesButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<CourseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        DefaultTableModel currentTableModel = (DefaultTableModel) coursesTable.getModel();
        currentTableModel.setNumRows(0);
        Object[] rowData = new Object[3];
        for (CourseEntry entry : courses) {
            rowData[0] = entry.getCourseCode();
            rowData[1] = entry.getDescription();
            rowData[2] = entry.getSeats();
            currentTableModel.addRow(rowData);
        }
    }//GEN-LAST:event_displayCoursesButtonActionPerformed

    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemesterButtonActionPerformed
        currentSemester = (String) currentSemesterComboBox.getSelectedItem();
        currentSemesterLabel.setText(currentSemester);
        rebuildCourseComboBoxes();
        displayCoursesButtonActionPerformed(null);
        displayScheduleButtonActionPerformed(null);
    }//GEN-LAST:event_changeSemesterButtonActionPerformed

    private void scheduleCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleCoursesButtonActionPerformed
        String status = "";
        if (CourseQueries.getCourseSeats(currentSemester, (String) selectCourseComboBox.getSelectedItem()) > ScheduleQueries.getScheduledStudentCount(currentSemester, (String) selectCourseComboBox.getSelectedItem())) {
            status = "s";
            scheduleCourseOutput.setText(currentStudent.lastFirstName() + " has been scheduled for " + (String) selectCourseComboBox.getSelectedItem());
        } else {
            status = "w";
            scheduleCourseOutput.setText(currentStudent.lastFirstName() + " has been waitlisted for " + (String) selectCourseComboBox.getSelectedItem());
        }

        ScheduleEntry newEntry = new ScheduleEntry(currentSemester, (String) selectCourseComboBox.getSelectedItem(), currentStudent.getStudentID(), status, new java.sql.Timestamp(System.currentTimeMillis()));
        ScheduleQueries.addScheduleEntry(newEntry);
        rebuildCurrentStudentCourseComboBox();
    }//GEN-LAST:event_scheduleCoursesButtonActionPerformed

    private void displayScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayScheduleButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<ScheduleEntry> schedule = ScheduleQueries.getScheduleByStudent(currentSemester, currentStudent.getStudentID());
        DefaultTableModel currentTableModel = (DefaultTableModel) displayScheduleTable.getModel();
        currentTableModel.setNumRows(0);
        Object[] rowData = new Object[3];
        for (ScheduleEntry entry : schedule) {
            rowData[0] = entry.getCourseCode();
            rowData[1] = entry.getStatus().equals("w") ? "Waitlisted" : "Scheduled";
            currentTableModel.addRow(rowData);
        }

    }//GEN-LAST:event_displayScheduleButtonActionPerformed

    private void displayCourseListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCourseListsActionPerformed
        ArrayList<ScheduleEntry> scheduledStudents = ScheduleQueries.getScheduledStudentsByCourse(currentSemester, (String) courseListAdminCoursesComboBox.getSelectedItem());
        ArrayList<ScheduleEntry> waitlistedStudents = ScheduleQueries.getWaitlistedStudentsByCourse(currentSemester, (String) courseListAdminCoursesComboBox.getSelectedItem());

        DefaultTableModel currentTableModel = (DefaultTableModel) scheduledStudentsTable.getModel();
        currentTableModel.setNumRows(0);
        Object[] rowData = new Object[3];

        for (ScheduleEntry entry : scheduledStudents) {
            StudentEntry current = StudentQueries.getStudent(entry.getStudentID());
            rowData[0] = current.getLastName();
            rowData[1] = current.getFirstName();
            rowData[2] = entry.getStudentID();
            currentTableModel.addRow(rowData);
        }

        currentTableModel = (DefaultTableModel) waitlistedStudentsTable.getModel();
        currentTableModel.setNumRows(0);
        rowData = new Object[3];

        for (ScheduleEntry entry : waitlistedStudents) {
            StudentEntry current = StudentQueries.getStudent(entry.getStudentID());
            rowData[0] = current.getLastName();
            rowData[1] = current.getFirstName();
            rowData[2] = entry.getStudentID();
            currentTableModel.addRow(rowData);
        }
    }//GEN-LAST:event_displayCourseListsActionPerformed

    private void dropStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentButtonActionPerformed

        dropStudentTextArea.setText("");
        StudentEntry currentStudent = StudentQueries.getStudent(studentNames(dropStudentComboBox)[1]);
        dropStudentTextArea.append((String) dropStudentComboBox.getSelectedItem() + " has been dropped from the list of stuents.\n\n");

        for (String thisSem : SemesterQueries.getSemesterList()) {
            String droppedCourses = "";
            String scheduledCourses = "";

            for (ScheduleEntry currentEntry : ScheduleQueries.getScheduleByStudent(thisSem, currentStudent.getStudentID())) {
                ScheduleQueries.dropStudentScheduleByCourse(thisSem, currentStudent.getStudentID(), currentEntry.getCourseCode());
                droppedCourses += ((String) dropStudentComboBox.getSelectedItem() + (currentEntry.getStatus().equals("w") ? " has been dropped from the waitlist for " : " has been dropped from ") + currentEntry.getCourseCode() + "\n");

                ArrayList<ScheduleEntry> waitlistedStudents = ScheduleQueries.getWaitlistedStudentsByCourse(thisSem, currentEntry.getCourseCode());
                if (waitlistedStudents.size() > 0) {
                    ScheduleQueries.updateScheduleEntry(thisSem, waitlistedStudents.get(0));
                    StudentEntry movedStudent = StudentQueries.getStudent(waitlistedStudents.get(0).getStudentID());
                    scheduledCourses += movedStudent.getLastName() + ", " + movedStudent.getLastName() + " " + waitlistedStudents.get(0).getStudentID() + " has been scheduled into " + waitlistedStudents.get(0).getCourseCode() + "\n";
                }
            }
            if (!droppedCourses.isEmpty() || !scheduledCourses.isEmpty()) {
                dropStudentTextArea.append("For Semester: " + thisSem + "\n");
                dropStudentTextArea.append(droppedCourses);
                dropStudentTextArea.append(scheduledCourses);
            }
        }

        StudentQueries.dropStudent(studentNames(dropStudentComboBox)[1]);
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_dropStudentButtonActionPerformed

    private void dropCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropCourseButtonActionPerformed

        dropCourseTextArea.setText("");
        String scheduledStudents = "Scheduled students dropped from the course:\n";
        String waitlistedStudents = "Waitlisted students dropped from the course:\n";
        StudentEntry currentStudent;
        for (ScheduleEntry currentEntry : ScheduleQueries.getScheduledStudentsByCourse(currentSemester, (String) dropCoursesComboBox.getSelectedItem())) {
            currentStudent = StudentQueries.getStudent(currentEntry.getStudentID());
            scheduledStudents += currentStudent.getLastName() + ", " + currentStudent.getFirstName() + " " + currentStudent.getStudentID() + "\n";
        }

        for (ScheduleEntry currentEntry : ScheduleQueries.getWaitlistedStudentsByCourse(currentSemester, (String) dropCoursesComboBox.getSelectedItem())) {
            currentStudent = StudentQueries.getStudent(currentEntry.getStudentID());
            waitlistedStudents += currentStudent.getLastName() + ", " + currentStudent.getFirstName() + " " + currentStudent.getStudentID() + "\n";
        }

        ScheduleQueries.dropScheduleByCourse(currentSemester, (String) dropCoursesComboBox.getSelectedItem());
        CourseQueries.dropCourse(currentSemester, (String) dropCoursesComboBox.getSelectedItem());
        dropCourseTextArea.append(scheduledStudents + "\n");
        dropCourseTextArea.append(waitlistedStudents);
        rebuildCourseComboBoxes();
    }//GEN-LAST:event_dropCourseButtonActionPerformed

    private void changeStudentGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeStudentGlobalActionPerformed

        currentStudent = StudentQueries.getStudent(studentNames(globalStudentComboBox)[1]);
        currentStudentLabel.setText((String) globalStudentComboBox.getSelectedItem());
        displayScheduleButtonActionPerformed(null);
        rebuildCurrentStudentCourseComboBox();
    }//GEN-LAST:event_changeStudentGlobalActionPerformed

    private void dropCourseStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropCourseStudentActionPerformed
        // TODO add your handling code here:
        dropCourseStudentTextArea.setText("");
        String dropCourse = (String) dropCourseComboBox.getSelectedItem();
        ScheduleQueries.dropStudentScheduleByCourse(currentSemester, currentStudent.getStudentID(), dropCourse);
        dropCourseStudentTextArea.append(currentStudent.ID() + " has been dropped from " + dropCourse + "\n");
        ArrayList<ScheduleEntry> waitlistedStudents = ScheduleQueries.getWaitlistedStudentsByCourse(currentSemester, dropCourse);
        if (waitlistedStudents.size() > 0) {
            ScheduleQueries.updateScheduleEntry(currentSemester, waitlistedStudents.get(0));
            dropCourseStudentTextArea.append(StudentQueries.getStudent(waitlistedStudents.get(0).getStudentID()).lastFirstName() + " has been scheduled into " + dropCourse + "\n");
        }

        displayScheduleButtonActionPerformed(null);
        rebuildCurrentStudentCourseComboBox();
    }//GEN-LAST:event_dropCourseStudentActionPerformed

    private String[] studentNames(javax.swing.JComboBox<String> input) {
        String[] val = ((String) input.getSelectedItem()).split(" ");
        String[] value = new String[2];
        value[0] = val[0] + " " + val[1];
        value[1] = val[2];
        return value;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseButton;
    private javax.swing.JLabel addCourseOutput;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JLabel addStudentOutput;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JButton changeStudentGlobal;
    private javax.swing.JTextField courseCodeEntry;
    private javax.swing.JTextField courseDescriptionEntry;
    private javax.swing.JComboBox<String> courseListAdminCoursesComboBox;
    private javax.swing.JTable coursesTable;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterDisplay;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JLabel currentStudentLabel;
    private javax.swing.JButton displayCourseLists;
    private javax.swing.JButton displayCoursesButton;
    private javax.swing.JButton displayScheduleButton;
    private javax.swing.JTable displayScheduleTable;
    private javax.swing.JButton dropCourseButton;
    private javax.swing.JComboBox<String> dropCourseComboBox;
    private javax.swing.JButton dropCourseStudent;
    private javax.swing.JTextArea dropCourseStudentTextArea;
    private javax.swing.JTextArea dropCourseTextArea;
    private javax.swing.JComboBox<String> dropCoursesComboBox;
    private javax.swing.JButton dropStudentButton;
    private javax.swing.JComboBox<String> dropStudentComboBox;
    private javax.swing.JTextArea dropStudentTextArea;
    private javax.swing.JTextField firstNameEntry;
    private javax.swing.JComboBox<String> globalStudentComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField lastNameEntry;
    private javax.swing.JLabel scheduleCourseOutput;
    private javax.swing.JButton scheduleCoursesButton;
    private javax.swing.JTable scheduledStudentsTable;
    private javax.swing.JSpinner seatsEntry;
    private javax.swing.JComboBox<String> selectCourseComboBox;
    private javax.swing.JTextField studentIDEntry;
    private javax.swing.JTable waitlistedStudentsTable;
    // End of variables declaration//GEN-END:variables
}
