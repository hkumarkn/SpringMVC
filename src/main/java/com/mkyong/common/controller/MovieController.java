package com.mkyong.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.common.model.Data;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private static final Log LOG = LogFactory.getLog(MovieController.class);
    
	@RequestMapping(value="/add/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
		model.addAttribute("movie", name);
		return "list";
	}	
	
    
	@RequestMapping(value="/movieNames", method = RequestMethod.POST)
    public ModelAndView getMovies(ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.addAllObjects(getMovieNames());
        return mav;       
    }
   
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/saveMovie", method = RequestMethod.PUT)
	public String saveMovie(@RequestBody Data data, ModelMap model) {
	    LOG.info("Got movie name = "+data);
	    return "test"; 
	}
   
    @RequestMapping(value="/saveMovie1", method = RequestMethod.PUT)
    public String saveMovie1(@RequestBody String data, ModelMap model) {
        LOG.info("Got movie name = "+data);
        return "test"; 
    }
	   
   private Map<String, String> getMovieNames() {
       Map<String, String> map = new HashMap<String, String>();
       map.put("1", "Baseev");
       map.put("2", "Sapna");
       map.put("3", "Ishaan");
       map.put("4", "Mummy");
       return map;
   }
   
   
}