package sample;
	
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import Modules.DefineMethodes;
import Modules.RotateImage;

public class Main extends Application {
	
	private String imagePath="";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			

			 ScrollPane scrollPane = new ScrollPane();
		        scrollPane.setMaxHeight(Double.MAX_VALUE);
		        scrollPane.setMaxWidth(Double.MAX_VALUE);
		        scrollPane.setPrefHeight(418.0);
		        scrollPane.setPrefWidth(766.0);

		        AnchorPane anchorPane = new AnchorPane();
		        anchorPane.setMaxHeight(Double.MAX_VALUE);
		        anchorPane.setMaxWidth(Double.MAX_VALUE);
		        anchorPane.setPrefHeight(416.0);
		        anchorPane.setPrefWidth(760.0);

		        // Add the AnchorPane to the ScrollPane
		        scrollPane.setContent(anchorPane);

		        // Add the ScrollPane to the center of the BorderPane
		        root.setCenter(scrollPane);
		        
		        
		        TextField inputPathTextField = new TextField();
		        inputPathTextField.setLayoutX(32.0);
		        inputPathTextField.setLayoutY(40.0);
		        inputPathTextField.setPrefHeight(26.0);
		        inputPathTextField.setPrefWidth(218.0);
		        inputPathTextField.setPromptText("C:\\Users\\user\\Desktop");
		        anchorPane.getChildren().add(inputPathTextField);

		        TextField sourceNameTextField = new TextField();
		        sourceNameTextField.setLayoutX(33.0);
		        sourceNameTextField.setLayoutY(98.0);
		        sourceNameTextField.setPromptText("name.bmp");
		        anchorPane.getChildren().add(sourceNameTextField);
		        

		        Label label1 = new Label();
		        label1.setLayoutX(33.0);
		        label1.setLayoutY(21.0);
		        label1.setPrefHeight(18.0);
		        label1.setPrefWidth(213.0);
		        label1.setText("Path-ul catre imagine");
		        label1.setWrapText(true);
		        anchorPane.getChildren().add(label1);

		        Label label2 = new Label();
		        label2.setLayoutX(35.0);
		        label2.setLayoutY(79.0);
		        label2.setPrefHeight(18.0);
		        label2.setPrefWidth(214.0);
		        label2.setText("Nume imagine");
		        label2.setWrapText(true);
		        anchorPane.getChildren().add(label2);

		        Label inputPathLabel = new Label();
		        inputPathLabel.setLayoutX(33.0);
		        inputPathLabel.setLayoutY(131.0);
		        inputPathLabel.setPrefHeight(65.0);
		        inputPathLabel.setPrefWidth(339.0);
		        inputPathLabel.setText("");
		        inputPathLabel.setWrapText(true);
		        inputPathLabel.setId("inputPathLabel");
		        anchorPane.getChildren().add(inputPathLabel);

		        Hyperlink searchPathHyperlink = new Hyperlink();
		        searchPathHyperlink.setLayoutX(230.0);
		        searchPathHyperlink.setLayoutY(82.0);
		        searchPathHyperlink.setPrefHeight(54.0);
		        searchPathHyperlink.setPrefWidth(134.0);
		        searchPathHyperlink.setText("Am uitat path-ul/numele");
		        searchPathHyperlink.setWrapText(true);
		        searchPathHyperlink.setId("Hyperlink1");
		        // Create a tooltip and set its text
		        Tooltip tooltip = new Tooltip("Press here for Search Button");
		        searchPathHyperlink.setTooltip(tooltip);
		        anchorPane.getChildren().add(searchPathHyperlink);

		        
		        Button searchPathButton = new Button();
		        searchPathButton.setLayoutX(260.0);
		        searchPathButton.setLayoutY(40.0);
		        searchPathButton.setVisible(false);
		        searchPathButton.setText("Search");
		        anchorPane.getChildren().add(searchPathButton);
	

		        Separator separator1 = new Separator();
		        separator1.setLayoutX(10.0);
		        separator1.setLayoutY(195.0);
		        separator1.setPrefHeight(2.0);
		        separator1.setPrefWidth(319.0);
		        anchorPane.getChildren().add(separator1);

		        ToggleGroup rotateToggleGroup = new ToggleGroup();
		        
		        RadioButton radioButton1 = new RadioButton();
		        radioButton1.setLayoutX(36.0);
		        radioButton1.setLayoutY(228.0);
		        radioButton1.setText("90");
		        radioButton1.setToggleGroup(rotateToggleGroup);
		        anchorPane.getChildren().add(radioButton1);
		        
		        
		     // RadioButton radioButton2
		        RadioButton radioButton2 = new RadioButton("270");
		        radioButton2.setLayoutX(138.0);
		        radioButton2.setLayoutY(228.0);
		        radioButton2.setMnemonicParsing(false);
		        radioButton2.setToggleGroup(rotateToggleGroup);
		        anchorPane.getChildren().add(radioButton2);

		        // RadioButton radioButton3
		        RadioButton radioButton3 = new RadioButton("180");
		        radioButton3.setLayoutX(84.0);
		        radioButton3.setLayoutY(228.0);
		        radioButton3.setMnemonicParsing(false);
		        radioButton3.setToggleGroup(rotateToggleGroup);
		        anchorPane.getChildren().add(radioButton3);

		        // Label label2
		        Label label3 = new Label("Selecteaza unghiul de rotire");
		        label3.setLayoutX(35.0);
		        label3.setLayoutY(198.0);
		        label3.setPrefWidth(283.0);
		        label3.setPrefHeight(18.0);
		        label3.setWrapText(true);
		        anchorPane.getChildren().add(label3);

		        // CheckBox overwriteCheckBox
		        CheckBox overwriteCheckBox = new CheckBox("Suprascrie imaginea veche");
		        overwriteCheckBox.setLayoutX(35.0);
		        overwriteCheckBox.setLayoutY(267.0);
		        overwriteCheckBox.setMnemonicParsing(false);
		        anchorPane.getChildren().add(overwriteCheckBox);

		        // ChoiceBox<String> renameChoiceBox
		        ChoiceBox<String> renameChoiceBox = new ChoiceBox<>();
		        renameChoiceBox.setLayoutX(33.0);
		        renameChoiceBox.setLayoutY(305.0);
		        renameChoiceBox.setPrefWidth(150.0);
		        // Add the entries to the ChoiceBox
		        renameChoiceBox.getItems().addAll("Default name", "Custom name");
		        // Set the default selected value
		        renameChoiceBox.setValue("Default name");
		        anchorPane.getChildren().add(renameChoiceBox);

		        // TextField renameTextField
		        TextField renameTextField = new TextField();
		        renameTextField.setLayoutX(222.0);
		        renameTextField.setLayoutY(305.0);
		        renameTextField.setPrefWidth(150);
		        renameTextField.setDisable(true);
		        renameTextField.setPromptText("NumeImagine");
		        anchorPane.getChildren().add(renameTextField);

		        // Separator separator2
		        Separator separator2 = new Separator();
		        separator2.setLayoutX(10.0);
		        separator2.setLayoutY(344.0);
		        separator2.setPrefWidth(331.0);
		        separator2.setPrefHeight(4.0);
		        anchorPane.getChildren().add(separator2);

		        // Button processButton
		        Button processButton = new Button("Proceseaza");
		        processButton.setLayoutX(28.0);
		        processButton.setLayoutY(356.0);
		        processButton.setMnemonicParsing(false);
		        processButton.setPrefWidth(95.0);
		        processButton.setPrefHeight(26.0);
		        anchorPane.getChildren().add(processButton);
		        
		     // Button extraButton
		        Button extraButton = new Button("Extra");
		        extraButton.setLayoutX(160.0);
		        extraButton.setLayoutY(356.0);
		        extraButton.setMnemonicParsing(false);
		        anchorPane.getChildren().add(extraButton);

		        // Label processLabel
		        TextField processLabel = new TextField("");
		        processLabel.setLayoutX(28.0);
		        processLabel.setLayoutY(385.0);
		        processLabel.setPrefWidth(710);
		        processLabel.setEditable(false);
		        processLabel.setBackground(Background.EMPTY);
		        processLabel.setBorder(Border.EMPTY);
		        processLabel.setCursor(Cursor.DEFAULT);
		        anchorPane.getChildren().add(processLabel);

		        // ImageView imageImageView
		        ImageView imageImageView = new ImageView();
		        imageImageView.setFitWidth(340.0);
		        imageImageView.setFitHeight(340.0);
		        imageImageView.setLayoutX(393.0);
		        imageImageView.setLayoutY(43.0);
		        imageImageView.setPickOnBounds(true);
		        imageImageView.setPreserveRatio(true);
		        anchorPane.getChildren().add(imageImageView);

		        
		        //------------------------------------
		        //functionalitatea controalelor
		        //-----------------------------------
		        
		        //dupa ce numele imaginii a fost introdus se verifica daca
		        //a fost introdusa si calea si se afiseaza imaginea
		        sourceNameTextField.setOnKeyPressed(event -> {
		            if (event.getCode() == KeyCode.ENTER) {
		            	if(!inputPathTextField.getText().equals("")){
		            		imagePath = inputPathTextField.getText() +
		            				"/" + sourceNameTextField.getText();
		            		inputPathLabel.setText(imagePath);
		            		try {
		            			Image image = new Image(new FileInputStream(imagePath));
		            			imageImageView.setImage(image);
		            		} catch (FileNotFoundException e) {
		            			e.printStackTrace();
		            		}
		            	}
		            	else {
		            		inputPathLabel.setText("Image path is empty");
		            	}
		            }
		        });
		        
		        
		        //la apasarea hyperlink-ului se va afisa butonul care 
			    //ne permite cautarea manuala a imaginii
			    searchPathHyperlink.setOnAction(e -> {
			         searchPathButton.setVisible(true);
			    });
			        
		        //cautam imaginea manual la apasarea butonului
		        searchPathButton.setOnAction(event -> {
		        	// Create file chooser and set initial directory
		        	FileChooser fileChooser = new FileChooser();
		        	fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		        	// Set file extension filter
		        	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.bmp");
		        	fileChooser.getExtensionFilters().add(extFilter);			           
		        	// Show file chooser and get selected file
		        	File selectedFile = fileChooser.showOpenDialog(primaryStage);

		        	// Show path, show image
		        	if (selectedFile != null) {
		        		imagePath=selectedFile.getPath();
		        		inputPathLabel.setText(imagePath);
		        		try {
		        			Image image = new Image(new FileInputStream(imagePath));
		        			imageImageView.setImage(image);
		        		} catch (FileNotFoundException e) {
		        			e.printStackTrace();
		        		}
		        	}
		        });
		       
		        // Set the action for the overwriteCheckBox
		        overwriteCheckBox.setOnAction(event -> {
		            if (overwriteCheckBox.isSelected()) {
		            	renameChoiceBox.setValue("Default name");
		                renameTextField.setText("");
		                renameChoiceBox.setDisable(true);
		                renameTextField.setDisable(true);     
		            } else {
		                renameChoiceBox.setDisable(false);
		            }
		        });
		        
		        //Daca se doreste un nume custom se permite scrierea lui
		        renameChoiceBox.setOnAction(event -> {
		            String selectedValue = renameChoiceBox.getSelectionModel().getSelectedItem();
		            if (selectedValue.equals("Custom name")) {
		                renameTextField.setDisable(false);
		            } else {
		                renameTextField.setDisable(true);
		                renameTextField.setText("");
		            }
		        });
		        
		        
		        //proceseaza imaginea
		        processButton.setOnAction(event -> {
		        	
		        	// verifica unghi de rotire selectat
		        	RadioButton selectedRadioButton = (RadioButton) rotateToggleGroup.getSelectedToggle();
		        	if (selectedRadioButton == null) {
		        	    processLabel.setText("Selecteaza unghi de rotire");
		        	    return;
		        	}
		        	
		        	// Get unghi de rotire
		        	String selectedText = selectedRadioButton.getText();
		        	int selectedValue = Integer.parseInt(selectedText);
		        	
		        	String savePath;
		        	
		        	//daca vrem overwrite pastram numele imaginii si path-ul
		        	if (overwriteCheckBox.isSelected()) {
		        	    savePath=imagePath;
		        	} else {
		        		String renameChoice = renameChoiceBox.getValue();
		        		if(renameChoice.equals("Default name")){
		        			//seteaza numele default al imaginii
		        			savePath = imagePath.replace(".bmp", "");
		        			savePath = savePath + "_rotated_"+ selectedText +".bmp";
		        		}
		        		else{
		        			//obtinele numele custom dat de user
		        			String renameText = renameTextField.getText();

		        			//obtine path-ul de scriere
		        			Path path = Paths.get(imagePath);
		        			savePath = path.getParent().toString();
		        			savePath = savePath + "\\" + renameText + ".bmp";
		        		}
		        	}
		        	
		        	processImage(processLabel, imageImageView, savePath, selectedValue);
		        });
		        
		        // butonul pentru scena cu controalele suplimentare
		        extraButton.setOnAction(event -> {
		        	extraScene();   
		        });

		        
		        
		        // Set the scene and show the stage
		        Scene scene = new Scene(root, 768, 418);
		        primaryStage.setScene(scene);
		        primaryStage.setTitle("Rotate your image");
		        primaryStage.show();
		        
		        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void processImage(TextField processLabel, ImageView imageImageView, String savePath, int grades) {
	   
		//verifica ca imaginea este accesibila
		File imageFile = new File(imagePath);
		if (!imageFile.exists() || !imageFile.isFile()) {
			processLabel.setText("Invalid image path");
			return;
		}
		
		// -----------------------
		// Parte extrasa din tema de anul trecut de la AWJ cu modificarea unor variabile
		
        //Citirea imaginii si crearea obiectului de tip RotateImage care va contine imaginea
        //care trebuie rotita
        DefineMethodes t1 = new DefineMethodes(); //obiect creeat pentru apelarea functiilor readImage si writeImage
		
        BufferedImage old = t1.readImage(imagePath);
        RotateImage t= new RotateImage(old, grades);
        
        
        //Apelarea functiei care va roti imaginea din obiectul t
        t.rotateImage(grades);

        //Scrierea noii imagini
        //t1.writeImage("C:\\Users\\saioc\\Desktop\\poza.bmp ", t.getRotatedImage());
        t1.writeImage(savePath, t.getRotatedImage());
        
		processLabel.setText("Saved at "+savePath);
        //afiseaza imaginea rotita dupa ce a fost salvata
        try {
			Image image = new Image(new FileInputStream(savePath));
			imageImageView.setImage(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void extraScene(){
		
		Stage secondaryStage = new Stage();
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setMaxHeight(Double.MAX_VALUE);
		anchorPane.setMaxWidth(Double.MAX_VALUE);
		anchorPane.setPrefHeight(416.0);
		anchorPane.setPrefWidth(760.0);
        
       // AnchorPane anchorPane = new AnchorPane();
       // anchorPane.setPrefSize(760.0, 416.0);

        Label label = new Label("EXTRA");
        label.setLayoutX(30.0);
        label.setLayoutY(14.0);
        label.setPrefSize(123.0, 51.0);
        label.setFont(new Font(36.0));
        anchorPane.getChildren().add(label);

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(25.0);
        passwordField.setLayoutY(140.0);
        anchorPane.getChildren().add(passwordField);

        Slider slider = new Slider();
        slider.setLayoutX(35.0);
        slider.setLayoutY(293.0);
        anchorPane.getChildren().add(slider);

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("List View", "Table View", "Tree View", "Tree Table View");
        comboBox.setLayoutX(30.0);
        comboBox.setLayoutY(224.0);
        comboBox.setPrefWidth(150.0);
        anchorPane.getChildren().add(comboBox);

        
        
        
        
        
        StackPane stackPane = new StackPane();
        stackPane.setLayoutX(226.0);
        stackPane.setLayoutY(51.0);
        stackPane.setPrefHeight(322.0);
        stackPane.setPrefWidth(496.0);
        stackPane.setAlignment(Pos.CENTER);
        
        ListView<String> listView = new ListView<>();
        listView.setPrefHeight(322.0);
        listView.setPrefWidth(148.0);
        listView.setVisible(false);
        // Populate the list view with some random strings
        ObservableList<String> items = FXCollections.observableArrayList(
            "Apple", "Banana", "Cherry", "Date", "Elderberry",
            "Fig", "Grape", "Honeydew", "Imbe", "Jackfruit",
            "Kiwi", "Lemon", "Mango", "Nectarine", "Orange"
        );
        listView.setItems(items);
        listView.setOnMouseClicked(event -> {
            // Get the selected item
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            
            // Print the selected item
            System.out.println("Clicked: " + selectedItem);
        });

        
        
        
        TableView<Person> tableView = new TableView<>();
        tableView.setPrefHeight(322.0);
        tableView.setPrefWidth(149.0);
        tableView.setVisible(false);
     // Create a list of persons with random names and ages
        ObservableList<Person> persons = FXCollections.observableArrayList();
        for (int i = 0; i < 10; i++) {
            String name = "Person " + i;
            int age = (int) (Math.random() * 50) + 20;
            Person person = new Person(name, age);
            persons.add(person);
        }
        // Create columns for the table
        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Person, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        // Add the columns to the table
        tableView.setItems(persons);
        tableView.getColumns().addAll(nameColumn, ageColumn);
        tableView.setOnMouseClicked(event -> {
            // Get the selected item
            Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
            
            // Show the selected person's data
            if (selectedPerson != null) {
                System.out.println("Clicked: " + selectedPerson.getName() + ", Age: " + selectedPerson.getAge());
            }
        });

        
        
      
        TreeItem<String> root = new TreeItem<>("Root");
        TreeItem<String> nodeA = new TreeItem<>("Node A");
        TreeItem<String> nodeB = new TreeItem<>("Node B");
        TreeItem<String> nodeC = new TreeItem<>("Node C");
        TreeItem<String> subNodeA1 = new TreeItem<>("Subnode A1");
        TreeItem<String> subNodeA2 = new TreeItem<>("Subnode A2");
        TreeItem<String> subNodeB1 = new TreeItem<>("Subnode B1");
        TreeItem<String> subNodeC1 = new TreeItem<>("Subnode C1");
        TreeItem<String> subNodeC2 = new TreeItem<>("Subnode C2");
        TreeItem<String> subNodeC3 = new TreeItem<>("Subnode C3");
        nodeA.getChildren().addAll(subNodeA1, subNodeA2);
        nodeB.getChildren().add(subNodeB1);
        nodeC.getChildren().addAll(subNodeC1, subNodeC2, subNodeC3);
        root.getChildren().addAll(nodeA, nodeB, nodeC);
        TreeView<String> treeView = new TreeView<>(root);
        treeView.setPrefHeight(200.0);
        treeView.setPrefWidth(200.0);
        treeView.setVisible(false);
        treeView.setOnMouseClicked(event -> {
            // Get the selected item
            TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
            
            // Show the selected item's data
            if (selectedItem != null) {
                System.out.println("Clicked: " + selectedItem.getValue());
            }
        });

        

        // Define the columns for treeTableView
        List<Person> persons2 = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35),
                new Person("Dave", 40)
        );
        final TreeItem<Person> root1 = new TreeItem<>(new Person("Persoane", 0));
        
        root1.setExpanded(true);
        persons.stream().forEach((person) -> {
            root1.getChildren().add(new TreeItem<>(person));
        });

        TreeTableColumn<Person, String> nameColumn1 =
                new TreeTableColumn<>("Name");
        nameColumn1.setPrefWidth(150);
        nameColumn1.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<Person, String> param) ->
                        new ReadOnlyObjectWrapper<>(param.getValue().getValue().getName())
        );

        TreeTableColumn<Person, Number> ageColumn1 =
                new TreeTableColumn<>("Age");
        ageColumn1.setPrefWidth(50);
        ageColumn1.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<Person, Number> param) ->
                        new ReadOnlyObjectWrapper<>(param.getValue().getValue().getAge())
        );

        TreeTableView<Person> treeTableView = new TreeTableView<>(root1);
        treeTableView.getColumns().setAll(nameColumn1, ageColumn1);
        
        treeTableView.setOnMouseClicked(event -> {
            // Get the selected item
            TreeItem<Person> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
            
            // Show the selected item's data
            if (selectedItem != null) {
                Person selectedPerson = selectedItem.getValue();
                System.out.println("Clicked: " + selectedPerson.getName() + ", Age: " + selectedPerson.getAge());
            }
        });


        // Add the TreeTableView to a container (VBox) and add the container to the scene
        VBox vbox = new VBox(treeTableView);
        vbox.setVisible(false);
        
        
        
        stackPane.getChildren().addAll(listView, tableView, treeView, vbox);
        anchorPane.getChildren().add(stackPane);
        
        
        
        
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setLayoutX(35.0);
        scrollBar.setLayoutY(76.0);
        scrollBar.setPrefSize(168.0, 14.0);
        anchorPane.getChildren().add(scrollBar);

        ProgressBar progressBar = new ProgressBar();
        progressBar.setLayoutX(25.0);
        progressBar.setLayoutY(173.0);
        progressBar.setPrefSize(186.0, 18.0);
        progressBar.setProgress(0.0);
        anchorPane.getChildren().add(progressBar);

        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setLayoutX(78.0);
        progressIndicator.setLayoutY(318.0);
        progressIndicator.setPrefSize(43.0, 46.0);
        progressIndicator.setProgress(0.0);
        anchorPane.getChildren().add(progressIndicator);

        
        Button backButton = new Button();
        backButton.setLayoutX(30.0);
        backButton.setLayoutY(370.0);
        backButton.setText("Back");
        anchorPane.getChildren().add(backButton);
        
        
        ToggleButton toggleButton = new ToggleButton("Hide");
        toggleButton.setLayoutX(118);
        toggleButton.setLayoutY(370);
        toggleButton.setMnemonicParsing(false);
        anchorPane.getChildren().add(toggleButton);
        
        
        //----------------------------
        // Controale scena EXTRA
        // ------------------------------
        
        //umple progressBar in functie de numarul de litere din parola
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            double progress = (double)newValue.length() / 20.0;
            progressBar.setProgress(progress);
        });
        
        //close this scene
        backButton.setOnAction(e -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });
        
        // set the progress indicator
        slider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double progress = newVal.doubleValue() / 100.0;
            progressIndicator.setProgress(progress);
        });
        
        
        // set the progress bar
        scrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            double fontSize = 10.0 + (newValue.doubleValue() / (scrollBar.getMax() - scrollBar.getMin())) * 32.0;
            label.setFont(new Font(fontSize));
        });
   
        
        // set the choiceBox
        comboBox.setOnAction(event -> {
            String selectedItem = comboBox.getSelectionModel().getSelectedItem();
            switch (selectedItem) {
                case "List View":
                    listView.setVisible(true);
                    tableView.setVisible(false);
                    treeView.setVisible(false);
                    vbox.setVisible(false);
                    break;
                case "Table View":
                    listView.setVisible(false);
                    tableView.setVisible(true);
                    treeView.setVisible(false);
                    vbox.setVisible(false);
                    break;
                case "Tree View":
                    listView.setVisible(false);
                    tableView.setVisible(false);
                    treeView.setVisible(true);
                    vbox.setVisible(false);
                    break;
                case "Tree Table View":
                    listView.setVisible(false);
                    tableView.setVisible(false);
                    treeView.setVisible(false);
                    vbox.setVisible(true);
                    break;
                default:
                    break;
            }
        });
        
        
     // Add an event listener to the selectedProperty of the ToggleButton
        toggleButton.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                // The ToggleButton is pressed (selected), so hide the StackPane
                stackPane.setVisible(false);
            } else {
                // The ToggleButton is released (unselected), so show the StackPane
                stackPane.setVisible(true);
            }
        });
        
        
        Scene scene = new Scene(anchorPane, 768, 418);
        secondaryStage.initModality(Modality.APPLICATION_MODAL);
        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Extra");
        secondaryStage.show();
	}
	
	
}
