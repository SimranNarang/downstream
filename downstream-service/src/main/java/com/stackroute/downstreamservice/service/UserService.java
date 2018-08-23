package com.stackroute.downstreamservice.service;

import com.stackroute.downstreamservice.model.AcademicQualification;
import com.stackroute.downstreamservice.model.Certificates;
import com.stackroute.downstreamservice.model.Experience;
import com.stackroute.downstreamservice.model.Location;
import com.stackroute.downstreamservice.model.PersonalInfo;
import com.stackroute.downstreamservice.model.Projects;
import com.stackroute.downstreamservice.model.Skills;
import com.stackroute.downstreamservice.model.User;

public interface UserService {
	public void saveCertificate(Certificates certificates);
	public void saveSkill(Skills skills);
	public void saveProject(Projects project);
	public void savePersonalInfo(PersonalInfo personalInfo);
	public void saveLocation(Location location);
	public void saveAcademies(AcademicQualification academies);
	public void saveExperience(Experience experience);
	
	public void deleteEntry(String ProfileId);
	public User updateEntry(User user, String ProfileId);
}
