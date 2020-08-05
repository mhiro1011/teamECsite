package jp.co.internous.ocean.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.ocean.model.domain.MstDestination;
import jp.co.internous.ocean.model.domain.MstUser;
import jp.co.internous.ocean.model.form.DestinationForm;
import jp.co.internous.ocean.model.mapper.MstDestinationMapper;
import jp.co.internous.ocean.model.mapper.MstUserMapper;
import jp.co.internous.ocean.model.session.LoginSession;


@Controller
@RequestMapping("/ocean/destination")
public class DestinationController {
	
	@Autowired
	private MstUserMapper userMapper;

	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	MstDestinationMapper mstDestinationMapper;
	
	private Gson gson = new Gson();
		
	@RequestMapping("/")
	public String index(Model m) {	
		
		List<MstUser> users = userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		MstUser user = users.get(0);
		
		
		m.addAttribute("user", user);
		m.addAttribute("loginSession",loginSession);
		
		return "destination";
	}
	
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody DestinationForm df) {
		
		
		MstDestination md = new MstDestination(df);
		int userId = loginSession.getUserId();
		md.setUserId(userId);
		int count = mstDestinationMapper.insert(md);
		
		
		Integer id = 0;
		if (count > 0) {
			id = mstDestinationMapper.findIdByUserId(userId);
		}
		
		return id.toString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestBody String destinationId) {
		
		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		String id = map.get("destinationId");
		
		int result = mstDestinationMapper.logicalDeleteById(Integer.parseInt(id));

		return result > 0;
		
	}
}