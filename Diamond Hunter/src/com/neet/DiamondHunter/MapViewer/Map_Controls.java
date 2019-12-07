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
        
        boat.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                select=1;
            }
        });

        axe.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                select=0;
            }
        });

        canvas.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                GraphicsContext gg = canvas.getGraphicsContext2D();
                if(select==0){
                    draw(gg);
                    if(first_boat){
                        gg.drawImage(
                                itemss[0],
                                save_boatY,save_boatX
                        );
                    }
                    if(!first_boat){
                        gg.drawImage(
                                itemss[0],
                                boatX*16,boatY*16
                        );
                    }
                    axeX=(int)e.getX()/16;
                    axeY=(int)e.getY()/16;
                    axex.setText(Integer.toString(axeX));
                    axey.setText(Integer.toString(axeY));
                    first_axe=false;
                    gg.drawImage(
                            itemss[1],
                            axeX*16,axeY*16
                    );
                }
                else{
                    draw(gg);
                    if(first_axe){
                        gg.drawImage(
                                itemss[1],
                                save_axeY,save_axeX
                        );
                    }
                    if(!first_axe) {
                        gg.drawImage(
                                itemss[1],
                                axeX * 16, axeY * 16
                        );
                    }
                    boatX=(int)e.getX()/16;
                    boatY=(int)e.getY()/16;
                    boatx.setText(Integer.toString(boatX));
                    boaty.setText(Integer.toString(boatY));
                    first_boat=false;
                    gg.drawImage(
                            itemss[0],
                            boatX*16,boatY*16
                    );
                }
            }
        });

        save.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
            	
               try{
                   if(first_axe==true && first_boat==true){
                       checkInvalidPos(axeY,axeX,boatY,boatX);}
                   if(first_axe==false && first_boat==false){
                       checkInvalidPos(axeX,axeY,boatX,boatY);}
                   if(first_axe==true && first_boat==false){
                       checkInvalidPos(axeY,axeX,boatX,boatY);}
                   if(first_axe==false && first_boat==true){
                       checkInvalidPos(axeX,axeY,boatY,boatX);}

                   if(first_axe == false){
                   save_axeX=axeY*16;
                   save_axeY=axeX*16;
                   }
                   if(first_boat == false){
                   save_boatX=boatY*16;
                   save_boatY=boatX*16;
                   }
                   saved.setContentText("Position of Axe (x,y)  : "+save_axeY/16+" "+save_axeX/16+"\nPosition of Boat (x,y) : "+save_boatY/16+" "+save_boatX/16 +
                		   "\n\n * please note that there is possibility that you might not be able to complete the game due to improper positioning.");
                   saved.showAndWait();
               }catch(MyException e){
                Popup_Msg.display("Alert",e.message);
               }

            }

            private void checkInvalidPos(int axeX, int axeY, int boatX, int boatY) throws MyException {
                // TODO Auto-generated method stub
            	if((axeX*16)==save_axeX && (axeY*16)==save_axeY && (boatX*16)==save_boatX && (boatY*16)==save_boatY){
            		throw new MyException("No changes are made. Please use the back button instead!");
            	}
                if(map[axeY][axeX] == 20 || map[axeY][axeX]==21){
                    throw new MyException("Axe cannot be placed onto a tree");
                }
                if(map[axeY][axeX]==22){
                    throw new MyException("Axe cannot be placed into water");
                }
                if(map[boatY][boatX] == 20 || map[boatY][boatX]==21){
                    throw new MyException("Boat cannot be placed onto a tree");
                }
                if(map[boatY][boatX]==22){
                    throw new MyException("Boat cannot be placed into water");
                }
            }
        });
    }
}
