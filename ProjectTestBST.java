import java.io.*;

public class ProjectTestBST {
    BufferedReader fileReader;
    BST<String> bst;

    public static void main(String[] args) {
        //we create an object called test
        ProjectTestBST test = new ProjectTestBST("datafile.txt");

        test.bst.inorder();
        test.bst.search("database");
        

    }

    public ProjectTestBST(String filename) {
        try {
            //we have an empty binary search tree, set root to null
            bst = new BST<String>();
            fileReader = new BufferedReader(new FileReader(filename));
            while(readNextRecord()) {

            }

        }
        catch (IOException e) {
            e.printStackTrace();


        }

    }

    public boolean readNextRecord() {

        if(fileReader == null) {
            System.out.println("Error you must open the file first");
            return false;
        }
        else {
            try {
                String data = fileReader.readLine();
                if (data == null) {
                    return false;
                
                }
                //parsing the id using the Integer 
                int titleId = Integer.parseInt(data);
                String title = fileReader.readLine();
                String author = fileReader.readLine();
                //doing the parsing and calling the function later
                int numKeys = Integer.parseInt(fileReader.readLine());
                Article article = new Article(titleId, title, author);

                String keyword;
                
                for(int i = 0; i < numKeys; i++) {
                    keyword = fileReader.readLine();
                    //article comes from earlier. Inserting in the keyword one article at a time
                    
                    bst.insert(keyword, article);

                }
                fileReader.readLine();
            }
            catch(NumberFormatException e) {
                System.out.println("Error: Number expected!");
                return false;
            }
            catch(Exception e) {
                System.out.println("Fatal Error" + e);
                return false;

            }
        }
        return true;
    }


}


