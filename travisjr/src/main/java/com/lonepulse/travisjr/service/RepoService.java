package com.lonepulse.travisjr.service;

/*
 * #%L
 * Travis Jr.
 * %%
 * Copyright (C) 2013 Lonepulse
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.List;

import android.app.Activity;
import android.content.Context;

import com.lonepulse.icklebot.annotation.inject.Pojo;
import com.lonepulse.travisjr.model.GitHubUser;
import com.lonepulse.travisjr.model.Repo;

/**
 * <p>This contract specifies the service offered on the {@link Repo}s which 
 * the user is a member of.
 * 
 * @since 1.1.0
 * <br><br>
 * @version 1.1.3
 * <br><br>
 * @author <a href="mailto:lahiru@lonepulse.com">Lahiru Sahan Jayasinghe</a>
 */
@Pojo(BasicRepoService.class)
public interface RepoService {

	/**
	 * <p>Retrieves the set of {@link Repo}s under CI which the saved user is associated with.
	 * 
	 * @return all associated {@link Repo}s
	 * 
	 * @throws RepoAccessException
	 * 			if the {@link Repo}(s) cannot be read via the remote endpoint.
	 * 
	 * @since 1.1.0
	 */
	List<Repo> getRepos();
	
	/**
	 * <p>Retrieves the set of {@link Repo}s under CI which the current user in context is 
	 * associated with.
	 * 
	 * @param activity
	 * 			the {@link Activity} {@link Context} which is used to discover any transient 
	 * 			{@link GitHubUser} which is in the current session
	 * 
	 * @return all associated {@link Repo}s for the transient user; if no transient user is 
	 * 		   discovered {@link #getRepos()} is used instead
	 * 
	 * @throws RepoAccessException
	 * 			if the {@link Repo}(s) cannot be read via the remote endpoint.
	 * 
	 * @since 1.1.0
	 */
	List<Repo> getRepos(Activity activity);
	
	/**
	 * <p>Retrieves the set of {@link Repo}s which the user is a <b>member</b> of.
	 * 
	 * @return all associated {@link Repo}s
	 * 
	 * @throws RepoAccessException
	 * 			if the {@link Repo}(s) cannot be read via the remote endpoint.
	 * 
	 * @since 1.1.0
	 */
	List<Repo> getReposByMember();
	
	/**
	 * <p>Retrieves the set of {@link Repo}s which the user is an <b>owner</b> of.
	 * 
	 * @return all associated {@link Repo}s
	 * 
	 * @throws RepoAccessException
	 * 			if the {@link Repo}(s) cannot be read via the remote endpoint.
	 * 
	 * @since 1.1.0
	 */
	List<Repo> getReposByOwner();
	
	/**
	 * <p>Retrieves the set of {@link Repo}s which the <i>given user</i> is a <b>member</b> of.
	 * 
	 * @param user
	 * 			the user whose repositories are to be retrieved
	 * 
	 * @return all associated {@link Repo}s
	 * 
	 * @throws RepoAccessException
	 * 			if the {@link Repo}(s) cannot be read via the remote endpoint.
	 * 
	 * @since 1.1.0
	 */
	List<Repo> getReposByMember(String user);
	
	/**
	 * <p>Retrieves the set of {@link Repo}s which the <i>given user</i> is an <b>owner</b> of.
	 * 
	 * @param user
	 * 			the user whose repositories are to be retrieved
	 * @return all associated {@link Repo}s
	 * 
	 * @throws RepoAccessException
	 * 			if the {@link Repo}(s) cannot be read via the remote endpoint.
	 * 
	 * @since 1.1.0
	 */
	List<Repo> getReposByOwner(String user);
	
	/**
	 * <p>Filters the given list of {@link Repo}s into a sublist containing the 
	 * repositories owned by the user.
	 * 
	 * @param repos
	 * 			the list of {@link Repo}s to be filtered
	 * 
	 * @return a sublist of the {@link Repo}s owned by the user
	 * 
	 * @throws RepoFilterException
	 * 			if the list of {@link Repo}s cannot be filtered by owner name
	 * 
	 * @since 1.1.0
	 */
	List<Repo> filterCreatedRepos(List<Repo> repos);
	
	/**
	 * <p>Filters the given list of {@link Repo}s into a sublist containing the 
	 * repositories contributed to (but not owned) by the user.
	 * 
	 * @param repos
	 * 			the list of {@link Repo}s to be filtered
	 * 
	 * @return a sublist of the {@link Repo}s contributed to by the user
	 * 
	 * @throws RepoFilterException
	 * 			if the list of {@link Repo}s cannot be filtered by owner name
	 * 
	 * @since 1.1.0
	 */
	List<Repo> filterContributedRepos(List<Repo> repos);
	
	/**
	 * <p>Filters the given list of {@link Repo}s for the given user into a sublist 
	 * containing the repositories owned by the user.
	 * 
	 * @param user
	 * 			the user whose repos are to be filtered
	 * 
	 * @param repos
	 * 			the list of {@link Repo}s to be filtered
	 * 
	 * @return a sublist of the {@link Repo}s owned by the user
	 * 
	 * @throws RepoFilterException
	 * 			if the list of {@link Repo}s cannot be filtered by owner name
	 * 
	 * @since 1.1.0
	 */
	List<Repo> filterCreatedRepos(String user, List<Repo> repos);
	
	/**
	 * <p>Filters the given list of {@link Repo}s for the given user into a sublist 
	 * containing the repositories contributed to (but not owned) by the user.
	 * 
	 * @param user
	 * 			the user whose repos are to be filtered
	 * 
	 * @param repos
	 * 			the list of {@link Repo}s to be filtered
	 * 
	 * @return a sublist of the {@link Repo}s contributed to by the user
	 * 
	 * @throws RepoFilterException
	 * 			if the list of {@link Repo}s cannot be filtered by owner name
	 * 
	 * @since 1.1.0
	 */
	List<Repo> filterContributedRepos(String user, List<Repo> repos);
	
	/**
	 * <p>Searches the given list of {@link Repo}s for the one whose name matches 
	 * the given repo name.
	 * 
	 * @param repoName
	 * 			the name of the {@link Repo} to find
	 * 
	 * @param repos
	 * 			the list of {@link Repo}s in which to search
	 * 
	 * @return the {@link Repo} whose name matches the given name, else {@code null} 
	 * 		   if the repo cannot be found
	 * 
	 * @since 1.1.0
	 */
	Repo findRepoByName(String repoName, List<Repo> repos);
}
