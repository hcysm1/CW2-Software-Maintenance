package com.neet.DiamondHunter.MapViewer;



public class Map_Controls implements Initializable{

	@Override
    public void initialize(URL location, ResourceBundle resources) {

        
        Alert saved = new Alert(Alert.AlertType.INFORMATION);
        saved.setTitle("Axe and Boat");
        saved.setHeaderText("Changes has been saved.");

        GraphicsContext g = canvas.getGraphicsContext2D();
        loadTiles("/Tilesets/testtileset.gif");
        loadItems("/Sprites/items.gif");
        loadMap("/Maps/testmap.map");

        draw(g);
        g.drawImage(
                itemss[0],
                save_boatY,save_boatX
        );
        g.drawImage(
                itemss[1],
                save_axeY,save_axeX
        );
        
        axey.setText(Integer.toString(save_axeX/16));
        axex.setText(Integer.toString(save_axeY/16));
        boaty.setText(Integer.toString(save_boatX/16));
        boatx.setText(Integer.toString(save_boatY/16));
}
