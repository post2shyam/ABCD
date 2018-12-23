#!/usr/bin/env bash
echo "Upload the apk to app center"

echo "Gen apk upload url of appcenter"
urlRequestRspJson=$(curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' --header "X-API-Token: ${upload_token}" 'https://api.appcenter.ms/v0.1/apps/post2shyam/abcd/release_uploads')

echo "Extract upload id from the above response"
upload_id=$(echo  ${urlRequestRspJson} | jq --raw-output '.upload_id')

echo "Extract the upload url from the above response"
upload_url=$(echo  ${urlRequestRspJson} | jq --raw-output '.upload_url')

echo ${upload_id}
echo ${upload_url}

echo "Upload the apk file to the upload the url"
uploadRspJson=$(curl -F "ipa=@./app/build/outputs/apk/release/app-release-unsigned.apk" ${upload_url})

echo ${uploadRspJson}

echo "Extract the release_url from the uploadRspJson"
release_url=$(echo  ${uploadRspJson} | jq --raw-output '.release_url')


echo "Update upload resource's status to committed"
committedStatusRsp=$(curl -X PATCH --header 'Content-Type: application/json' --header 'Accept: application/json' --header "X-API-Token: ${upload_token}" -d '{ "status": "committed"  }' "https://api.appcenter.ms/v0.1/apps/post2shyam/abcd/release_uploads/${upload_id}")
committedId=$(echo  ${committedStatusRsp} | jq --raw-output '.release_id')
committedUrl=$(echo  ${committedStatusRsp} | jq --raw-output '.release_url')

echo "Distribute the uploaded release to distribution group"
relNotesRsp=$(curl -X PATCH --header 'Content-Type: application/json' --header 'Accept: application/json' --header "X-API-Token: ${upload_token}" -d '{ "destination_name": "QA Testers", "release_notes": "New release is available." }' "https://api.appcenter.ms/${committedUrl}")
echo ${relNotesRsp}

