package org.blog.api.services;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.blog.api.model.Post;
import org.blog.api.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	PostRepository pRepo;
	
	public List<Post> getPosts(){
		return this.pRepo.findAll();
	}
	
	public Post getPost(String id) {
		try {
			Post post = this.pRepo.findAll().stream().filter(t -> t.getId().equals(id)).findFirst()
					.get();
			return post;
		} catch (NoSuchElementException ex) {
			return null;
		}
	}
	
	public List<Post> getPostBySeach(String searchWord){
		String regex = this.regex(searchWord.toLowerCase());
		List<Post> result = pRepo.findByRegex(regex);
		for (Post post : pRepo.findByRegexPost(regex)) 	
		{ 
		    if(!(result.contains(post))) {
		    	result.add(post);
		    }
		}
		return result;
	}
	
	public List<Post> getPostByCategory(String category){
		try {
		return this.pRepo.findByCategory(category);
		}
		catch(Exception ex) {
			return null;
		}
	}

	public boolean createPost(Post post) {
		try {
		 	this.pRepo.insert(post);
		 	return true;
		}
		catch(Exception ex) {
			return false;
		}
			
	}
	
	//Delete Post
			public boolean deletePost(String id) {
				try {
				 	this.pRepo.deleteById(id);
				 	return true;
				}
				catch(Exception ex) {
				return false;
				}
				
			}
			
  //Filtered words
  private String regex(String search){
	  
	  String[] nonKeyWords = {"is","with","the","and","for",","
			  ,"if","at","he","she","him","her","we","they",
			  "but","them","their","go","come","on","up","down","so"};
	  List<String> listOfNonKeyWords = Arrays.asList(nonKeyWords);
	  String[] splitSearchWord = search.split(" ");
	  //form keywords
	  String regexWord ="";
	  for (int i = 0;i<splitSearchWord.length; i++) 
		{ 
		  if(splitSearchWord[i].length()>1 && !(listOfNonKeyWords.contains(splitSearchWord[i]))) {
			  if(i == ((splitSearchWord.length)-1)) {
				  regexWord += splitSearchWord[i]+"";
			  }
			  else {
				  regexWord += splitSearchWord[i]+"|";  
			  }
		  }
		}
	  
	return regexWord;
	  
  }
}
