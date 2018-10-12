package forms;

import javax.servlet.http.HttpServletRequest;

public class Cook {
    private int    id;
    private String name;
    private String category;
    private String description;
    private String timeP;
    private String timeF;
    private String level;
    private String datePublication;
    private String namePublisher;
    private String namePhoto;

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto( String namePhoto ) {
        this.namePhoto = namePhoto;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getTimeP() {
        return timeP;
    }

    public void setTimeP( String timeP ) {
        this.timeP = timeP;
    }

    public String getTimeF() {
        return timeF;
    }

    public void setTimeF( String timeF ) {
        this.timeF = timeF;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel( String string ) {
        this.level = string;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication( String datePublication ) {
        this.datePublication = datePublication;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher( String namePublisher ) {
        this.namePublisher = namePublisher;
    }

    public static Cook getCook( HttpServletRequest request ) {
        Cook cook = new Cook();

        cook.setName( request.getParameter( "nameCook" ) );
        cook.setCategory( request.getParameter( "category" ) );
        cook.setDescription( request.getParameter( "description" ) );
        cook.setNamePublisher( request.getParameter( "userPublisher" ) );
        cook.setLevel( request.getParameter( "level" ) );
        cook.setTimeF( request.getParameter( "timeC" ) );
        cook.setTimeP( request.getParameter( "timeP" ) );

        return cook;
    }

}
