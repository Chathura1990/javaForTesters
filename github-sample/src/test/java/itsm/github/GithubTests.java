package itsm.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("f335c8b1c740115e3b64024dce52ca160dc00a25");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("Chathura1990", "javaForTesters")).commits();
        for(RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String,String>().build())){
            System.out.println(new RepoCommit.Smart(commit).message());
        }

    }
}
