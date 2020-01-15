package dao;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;

import dao.Dbconnection;

@Path("/user")
public class LoginService {
	Dbconnection dao = new Dbconnection();
	@GET
	@Path("/{id}") // to fetch the data from browser
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@PathParam("id") String id) {
		return getAllUsersList(id);
	}
	
	public String getAllUsersList(String id) {
		// String userListData = null;
		try {
			ArrayList<UserVo> userList = null;
			
			userList = dao.getAll(id);
			// ArrayList
			for (UserVo userVO : userList) {
				if (userVO.getId().equals(id)) {

					return "Logged in User:" + userVO.getUsername() + " " + "id:" + id;
				}
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return "You are not a Valid User";
	}
	
	
	@POST
	@Path("/usercreate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String creat(UserVo user) throws ClassNotFoundException{
		
		if(dao.createuser(user)!=null)
		{
			return user.toString()+"user registered....";
		}
		return "user not register";
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(UserVo user,@PathParam("id") String id) throws Exception 
	{
		
		if(dao.update(user,id)!=null)
		{
			return "updated successfully...";
		}
		return "not updated sucessfully.....";
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("id") String id)
	{
		if(dao.delete(id)!=null)
		{
			return "user deleted Successfully....";
		}
		return "user does not exist";
	}	
}


