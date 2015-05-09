package server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.Room;
import util.R;

public interface RMILobby extends Remote {

	ArrayList<Room> getRooms() throws RemoteException;

	R.info enterRoom(String id, String roomName) throws RemoteException;

	R.info createRoom(Room room) throws RemoteException;
	
	RMIRoom getRoomService(String roomName) throws RemoteException;

	R.info test(String command) throws RemoteException;
}
